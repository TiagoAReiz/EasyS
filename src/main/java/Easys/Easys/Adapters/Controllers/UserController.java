package Easys.Easys.Adapters.Controllers;

import Easys.Easys.Adapters.Dtos.ProfessionalDtos.ProfessionalCreateDto;
import Easys.Easys.Adapters.Dtos.UserDtos.UserCreateDto;
import Easys.Easys.Core.UseCases.CreateUserUseCase;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class UserController {

    private final CreateUserUseCase createUserUseCase;

    public UserController(CreateUserUseCase createUserUseCase) {
        this.createUserUseCase = createUserUseCase;
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody UserCreateDto userDto) {
        return createUserUseCase.create(userDto);
    }

    @PostMapping("/create-professional")
    public ResponseEntity<?> createProfessional(@RequestBody ProfessionalCreateDto proDto) {
        return createUserUseCase.createProfessional(proDto);
    }
}
