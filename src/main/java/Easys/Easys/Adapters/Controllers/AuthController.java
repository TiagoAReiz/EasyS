package Easys.Easys.Adapters.Controllers;

import Easys.Easys.Adapters.Dtos.ProfessionalDtos.ProfessionalCreateDto;
import Easys.Easys.Adapters.Dtos.UserDtos.LoginDto;
import Easys.Easys.Adapters.Dtos.UserDtos.LoginResponse;
import Easys.Easys.Adapters.Dtos.UserDtos.UserCreateDto;
import Easys.Easys.Core.UseCases.AuthUseCase;
import Easys.Easys.Core.UseCases.CreateUserUseCase;

import Easys.Easys.Core.UseCases.ProfessionalUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthController {

    private final CreateUserUseCase createUserUseCase;
    private final AuthUseCase authUseCase;
    private final ProfessionalUseCase professionalUseCase;

    public AuthController(CreateUserUseCase createUserUseCase, AuthUseCase authUseCase, ProfessionalUseCase professionalUseCase) {
        this.createUserUseCase = createUserUseCase;
        this.authUseCase = authUseCase;
        this.professionalUseCase = professionalUseCase;
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody UserCreateDto userDto) {
        return createUserUseCase.create(userDto);
    }

    @PostMapping("/create-professional")
    public ResponseEntity<?> createProfessional(@RequestBody ProfessionalCreateDto proDto) {
        return professionalUseCase.createProfessional(proDto);
    }
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginDto loginDto) {
        return ResponseEntity.ok(authUseCase.login(loginDto));
    }
}
