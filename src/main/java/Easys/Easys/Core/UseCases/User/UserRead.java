package Easys.Easys.Core.UseCases.User;

import org.springframework.http.ResponseEntity;

import Easys.Easys.Core.Model.User;

import java.util.List;

public interface UserRead {
    ResponseEntity<User> findById(Long id);
    ResponseEntity<List<User>> findAll();
    ResponseEntity<User> findByEmail(String email);
}