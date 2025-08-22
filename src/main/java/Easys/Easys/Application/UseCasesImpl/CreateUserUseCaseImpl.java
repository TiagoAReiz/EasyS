package Easys.Easys.Application.UseCasesImpl;

import Easys.Easys.Adapters.UserPersistence;
import Easys.Easys.Adapters.Dtos.ProfessionalDtos.ProfessionalCreateDto;
import Easys.Easys.Adapters.Dtos.UserDtos.UserCreateDto;
import Easys.Easys.Adapters.Mappers.ProfessionalMapper;
import Easys.Easys.Adapters.Mappers.UserMapper;
import Easys.Easys.Core.Model.Professional;
import Easys.Easys.Core.Model.User;
import Easys.Easys.Core.UseCases.CreateUserUseCase;
import Easys.Easys.Infra.Persistence.Entities.UserEntity;
import Easys.Easys.Infra.Persistence.Repositories.UserRepository;
import Easys.Easys.Infra.Persistence.Repositories.ProfessionalRepository;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private final UserMapper map;
    private final BCryptPasswordEncoder passwordEncoder;
    private final UserPersistence userPersistence;

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final ProfessionalRepository professionalRepository;
    private final ProfessionalMapper professionalMapper;
    private final ProfessionalMapper proMap;


    public CreateUserUseCaseImpl(
            UserMapper map,
            BCryptPasswordEncoder passwordEncoder,
            UserPersistence userPersistence,
            UserRepository userRepository,
            UserMapper userMapper,
            ProfessionalMapper professionalMapper,
            ProfessionalMapper proMap,
            ProfessionalRepository professionalRepository) {
        this.map = map;
        this.passwordEncoder = passwordEncoder;
        this.userPersistence = userPersistence;
        this.userRepository = userRepository;
        this.userMapper = userMapper;       
        this.professionalRepository = professionalRepository;
        this.professionalMapper = professionalMapper;
        this.proMap = proMap;
    }

    @Override
    public ResponseEntity<?> create(UserCreateDto userDto) {
        User user = map.toModel(userDto);
        if (userPersistence.findByEmail(user.getEmail()) != null) {
            return new ResponseEntity<>("User already exists", HttpStatus.CONFLICT);
        }
        user.setPasswordHash(passwordEncoder.encode(user.getPasswordHash()));
        return userPersistence.save(user);
    }

    @Override
    @Transactional
    public ResponseEntity<?> createProfessional(ProfessionalCreateDto proDto) {
        if (userRepository.findByEmail(proDto.email()) != null) {
            return new ResponseEntity<>("User already exists", HttpStatus.CONFLICT);
        }
        if (professionalRepository.existsByCpf(proDto.cpf())) {
            return new ResponseEntity<>("Professional with this CPF already exists", HttpStatus.CONFLICT);
        }

        User user = proMap.toUserModel(proDto);
        user.setPasswordHash(passwordEncoder.encode(user.getPasswordHash()));

        UserEntity userEntity = userMapper.toEntity(user);
        userEntity = userRepository.save(userEntity);

        Professional professional = proMap.toModel(proDto);

        var professionalEntity = professionalMapper.toEntity(professional, userEntity);
        professionalRepository.save(professionalEntity);

        return ResponseEntity.ok().build();
    }
}
