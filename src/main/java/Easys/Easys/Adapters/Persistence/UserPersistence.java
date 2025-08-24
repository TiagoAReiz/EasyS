package Easys.Easys.Adapters.Persistence;

import Easys.Easys.Core.Model.User;
import Easys.Easys.Infra.Persistence.Repositories.UserRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

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
}
