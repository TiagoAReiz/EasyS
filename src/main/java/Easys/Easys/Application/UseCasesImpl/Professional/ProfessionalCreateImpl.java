package Easys.Easys.Application.UseCasesImpl.Professional;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import Easys.Easys.Adapters.Dtos.ProfessionalDtos.ProfessionalCreateDto;
import Easys.Easys.Adapters.Mappers.ProfessionalMapper;
import Easys.Easys.Adapters.Persistence.ProfessionalPersistence;
import Easys.Easys.Adapters.Persistence.UserPersistence;
import Easys.Easys.Core.Model.User;
import Easys.Easys.Core.UseCases.Professional.ProfessionalCreate;


@Service
public class ProfessionalCreateImpl implements ProfessionalCreate {


    private final ProfessionalMapper proMap;
    private final UserPersistence userPersistence;
    private final ProfessionalPersistence professionalPersistence;
    private final BCryptPasswordEncoder passwordEncoder;

    

    public ProfessionalCreateImpl(
            ProfessionalMapper proMap,
            UserPersistence userPersistence,
            ProfessionalPersistence professionalPersistence,
            BCryptPasswordEncoder passwordEncoder
) {
        this.proMap = proMap;
       
        this.userPersistence = userPersistence;
        this.professionalPersistence = professionalPersistence;
        this.passwordEncoder = passwordEncoder;

    }

    @Override
    public ResponseEntity<?> createProfessional(ProfessionalCreateDto proDto) {
        if (userPersistence.findByEmail(proDto.email()) != null) {
            return new ResponseEntity<>("User already exists", HttpStatus.CONFLICT);
        }
        if (professionalPersistence.existsByCpf(proDto.cpf())) {
            return new ResponseEntity<>("Professional with this CPF already exists", HttpStatus.CONFLICT);
        }
        User user = proMap.toUserModel(proDto);
        user.setPasswordHash(passwordEncoder.encode(user.getPasswordHash()));
        userPersistence.save(user);
        professionalPersistence.save(proMap.toModel(proDto, user));


        return ResponseEntity.ok().build();
    }
}