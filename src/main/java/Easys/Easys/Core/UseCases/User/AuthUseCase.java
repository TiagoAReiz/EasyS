package Easys.Easys.Core.UseCases.User;

import Easys.Easys.Adapters.Dtos.UserDtos.LoginDto;
import Easys.Easys.Adapters.Dtos.UserDtos.LoginResponse;



public interface AuthUseCase {
    public LoginResponse login(LoginDto loginDto);
}
