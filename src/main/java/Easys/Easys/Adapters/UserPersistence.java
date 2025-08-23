package Easys.Easys.Adapters;

import Easys.Easys.Adapters.Mappers.UserMapper;
import Easys.Easys.Core.Model.User;
import Easys.Easys.Infra.Persistence.Repositories.UserRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class UserPersistence  {
    private final UserRepository userRepository;
    private final UserMapper map;
    public UserPersistence(UserRepository userRepository, UserMapper map) {
        this.userRepository = userRepository;
        this.map = map;
    }
    public UserDetails findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    public ResponseEntity<?> save(User user) {
        userRepository.save(map.toEntity(user));
        return ResponseEntity.ok().build();
    }
}
