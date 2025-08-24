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



@Service
public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private final UserMapper map;
    private final BCryptPasswordEncoder passwordEncoder;
    private final UserPersistence userPersistence;

    public CreateUserUseCaseImpl(
            UserMapper map,
            BCryptPasswordEncoder passwordEncoder,
            UserPersistence userPersistence) {
        this.map = map;
        this.passwordEncoder = passwordEncoder;
        this.userPersistence = userPersistence;
        
    }

    @Override
    public ResponseEntity<?> create(UserCreateDto userDto) {
        User user = map.toModel(userDto);
        if (userPersistence.findByEmail(user.getEmail()) != null) {
            return new ResponseEntity<>("User already exists", HttpStatus.CONFLICT);
        }
        user.setPasswordHash(passwordEncoder.encode(user.getPasswordHash()));
        return userPersistence.save(map.toEntity(user));
    }

   
}
