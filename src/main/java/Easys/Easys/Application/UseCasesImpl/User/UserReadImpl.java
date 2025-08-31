package Easys.Easys.Application.UseCasesImpl.User;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import Easys.Easys.Adapters.Persistence.UserPersistence;
import Easys.Easys.Core.Model.User;
import Easys.Easys.Core.UseCases.User.UserRead;

import java.util.List;
import java.util.Optional;

@Service
public class UserReadImpl implements UserRead {
    
    private final UserPersistence userPersistence;
    
    public UserReadImpl(UserPersistence userPersistence) {
        this.userPersistence = userPersistence;
    }
    
    @Override
    public ResponseEntity<User> findById(Long id) {
        Optional<User> user = userPersistence.findByIdOptional(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        }
        return ResponseEntity.notFound().build();
    }
    
    @Override
    public ResponseEntity<List<User>> findAll() {
        List<User> users = userPersistence.findAll();
        return ResponseEntity.ok(users);
    }
    
    @Override
    public ResponseEntity<User> findByEmail(String email) {
        try {
            User user = (User) userPersistence.findByEmail(email);
            if (user != null) {
                return ResponseEntity.ok(user);
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}