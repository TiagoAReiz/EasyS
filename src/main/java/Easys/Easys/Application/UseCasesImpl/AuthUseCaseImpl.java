package Easys.Easys.Application.UseCasesImpl;


import Easys.Easys.Adapters.Dtos.UserDtos.LoginDto;
import Easys.Easys.Adapters.Dtos.UserDtos.LoginResponse;
import Easys.Easys.Core.UseCases.AuthUseCase;
import Easys.Easys.Infra.Config.Security.JwtTokenService;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthUseCaseImpl implements AuthUseCase {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenService jwtTokenService;

    public AuthUseCaseImpl(AuthenticationManager authenticationManager, JwtTokenService jwtTokenService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenService = jwtTokenService;
    }

    @Override
    public LoginResponse login(LoginDto loginDto) {
        Authentication authRequest = new UsernamePasswordAuthenticationToken(loginDto.email(), loginDto.password());
        try {
            Authentication authResult = authenticationManager.authenticate(authRequest);
            String username = authResult.getName();
            String token = jwtTokenService.generateToken(username);
            return new LoginResponse(token);
        } catch (BadCredentialsException ex) {
            throw new BadCredentialsException("Invalid credentials");
        }
    }
}
