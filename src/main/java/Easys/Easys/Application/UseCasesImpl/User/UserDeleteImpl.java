package Easys.Easys.Application.UseCasesImpl.User;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import Easys.Easys.Adapters.Persistence.UserPersistence;
import Easys.Easys.Core.UseCases.User.UserDelete;

@Service
public class UserDeleteImpl implements UserDelete {
    
    private final UserPersistence userPersistence;
    
    public UserDeleteImpl(UserPersistence userPersistence) {
        this.userPersistence = userPersistence;
    }
    
    @Override
    public ResponseEntity<?> delete(Long id) {
        if (!userPersistence.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        
        return userPersistence.delete(id);
    }
}