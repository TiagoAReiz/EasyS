package Easys.Easys.Core.UseCases;

import org.springframework.http.ResponseEntity;

import Easys.Easys.Adapters.Dtos.ProfessionalDtos.ProfessionalCreateDto;
import Easys.Easys.Adapters.Dtos.UserDtos.UserCreateDto;

public interface CreateUserUseCase {

    public ResponseEntity<?> create(UserCreateDto userDto);
    public ResponseEntity<?> createProfessional( ProfessionalCreateDto proDto);

}
