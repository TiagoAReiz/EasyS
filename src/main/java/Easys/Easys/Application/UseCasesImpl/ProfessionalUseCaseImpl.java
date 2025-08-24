package Easys.Easys.Application.UseCasesImpl;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import Easys.Easys.Adapters.ProfessionalPersistence;
import Easys.Easys.Adapters.UserPersistence;
import Easys.Easys.Adapters.Dtos.ProfessionalDtos.ProfessionalCreateDto;
import Easys.Easys.Adapters.Mappers.ProfessionalMapper;
import Easys.Easys.Core.Model.Professional;
import Easys.Easys.Core.UseCases.ProfessionalUseCase;
import Easys.Easys.Infra.Persistence.Entities.UserEntity;
import org.springframework.stereotype.Service;


@Service
public class ProfessionalUseCaseImpl implements ProfessionalUseCase {

    private final ProfessionalMapper proMap;
    private final UserPersistence userPersistence;
    private final ProfessionalPersistence professionalPersistence;

    

    public ProfessionalUseCaseImpl(
            ProfessionalMapper proMap,

            UserPersistence userPersistence,
            ProfessionalPersistence professionalPersistence
) {
        this.proMap = proMap;
       
        this.userPersistence = userPersistence;
        this.professionalPersistence = professionalPersistence;

    }

    @Override
    public ResponseEntity<?> createProfessional(ProfessionalCreateDto proDto) {
        if (userPersistence.findByEmail(proDto.email()) != null) {
            return new ResponseEntity<>("User already exists", HttpStatus.CONFLICT);
        }
        if (professionalPersistence.existsByCpf(proDto.cpf())) {
            return new ResponseEntity<>("Professional with this CPF already exists", HttpStatus.CONFLICT);
        }

        UserEntity user = proMap.toUserEntity(proDto);
        userPersistence.save(user);

        Professional professional = proMap.toModel(proDto);

        var professionalEntity = proMap.toEntity(professional, user);
        professionalPersistence.save(professionalEntity);

        return ResponseEntity.ok().build();
    }
}