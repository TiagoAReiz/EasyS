package Easys.Easys.Core.UseCases.User;

import org.springframework.http.ResponseEntity;

import Easys.Easys.Adapters.Dtos.UserDtos.UserUpdateDto;

public interface UserUpdate {
    ResponseEntity<?> update(Long id, UserUpdateDto userUpdateDto);
}