package Easys.Easys.Core.UseCases.User;

import org.springframework.http.ResponseEntity;

import Easys.Easys.Adapters.Dtos.UserDtos.UserCreateDto;

public interface UserCreate {

    public ResponseEntity<?> create(UserCreateDto userDto);


}
