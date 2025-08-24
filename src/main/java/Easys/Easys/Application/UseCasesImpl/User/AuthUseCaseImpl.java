package Easys.Easys.Application.UseCasesImpl.User;


import Easys.Easys.Adapters.Dtos.UserDtos.LoginDto;
import Easys.Easys.Adapters.Dtos.UserDtos.LoginResponse;
import Easys.Easys.Core.UseCases.User.AuthUseCase;
import Easys.Easys.Infra.Config.Security.JwtTokenService;
import Easys.Easys.Infra.Config.Security.UserDetailsServiceImpl;


import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthUseCaseImpl implements  AuthUseCase {
    private final UserDetailsServiceImpl userDetailsService;
    private final JwtTokenService jwtTokenService;
    private final AuthenticationManager authenticationManager;

    public AuthUseCaseImpl(UserDetailsServiceImpl userDetailsService, AuthenticationManager authenticationManager, JwtTokenService jwtTokenService) {
        this.userDetailsService = userDetailsService;
        this.jwtTokenService = jwtTokenService;
        this.authenticationManager = authenticationManager;
    }
    @Override
    public LoginResponse login(LoginDto loginDto){
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(loginDto.email(), loginDto.password())
        );
        UserDetails user = userDetailsService.loadUserByUsername(loginDto.email());
        var roles = user.getAuthorities()
                        .stream()
                        .map(auth -> auth.getAuthority())
                        .toList();
        var token = jwtTokenService.generateToken(user.getUsername(), roles);
        return new LoginResponse(token);

    };

    
}
