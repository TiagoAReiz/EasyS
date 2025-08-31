package Easys.Easys.Adapters.Persistence;

import Easys.Easys.Core.Model.User;
import Easys.Easys.Infra.Persistence.Repositories.UserRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserPersistence  {
    private final UserRepository userRepository;

    public UserPersistence(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public UserDetails findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    public ResponseEntity<?> save(User user) {
        userRepository.save(user);
        return ResponseEntity.ok().build();
    }
    public User findById(Long id) {
        return userRepository.findById(id).get();
    }
    
    public Optional<User> findByIdOptional(Long id) {
        return userRepository.findById(id);
    }
    
    public List<User> findAll() {
        return userRepository.findAll();
    }
    
    public ResponseEntity<?> update(User user) {
        userRepository.save(user);
        return ResponseEntity.ok().build();
    }
    
    public ResponseEntity<?> delete(Long id) {
        userRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
    
    public boolean existsById(Long id) {
        return userRepository.existsById(id);
    }
}
