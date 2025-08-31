package Easys.Easys.Application.UseCasesImpl.User;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import Easys.Easys.Adapters.Dtos.UserDtos.UserUpdateDto;
import Easys.Easys.Adapters.Persistence.UserPersistence;
import Easys.Easys.Core.Model.User;
import Easys.Easys.Core.UseCases.User.UserUpdate;

import java.util.Optional;

@Service
public class UserUpdateImpl implements UserUpdate {
    
    private final UserPersistence userPersistence;
    
    public UserUpdateImpl(UserPersistence userPersistence) {
        this.userPersistence = userPersistence;
    }
    
    @Override
    public ResponseEntity<?> update(Long id, UserUpdateDto userUpdateDto) {
        Optional<User> existingUserOpt = userPersistence.findByIdOptional(id);
        
        if (!existingUserOpt.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        
        User existingUser = existingUserOpt.get();
        
        // Update fields from DTO
        existingUser.setUsername(userUpdateDto.username());
        existingUser.setEmail(userUpdateDto.email());
        existingUser.setPhone(userUpdateDto.phone());
        existingUser.setAddress(userUpdateDto.address());
        existingUser.setCity(userUpdateDto.city());
        existingUser.setState(userUpdateDto.state());
        existingUser.setCountry(userUpdateDto.country());
        existingUser.setZip(userUpdateDto.zip());
        
        try {
            return userPersistence.update(existingUser);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}