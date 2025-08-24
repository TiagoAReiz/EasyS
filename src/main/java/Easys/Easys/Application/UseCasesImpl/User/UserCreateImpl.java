package Easys.Easys.Application.UseCasesImpl.User;

import Easys.Easys.Adapters.Dtos.UserDtos.UserCreateDto;
import Easys.Easys.Adapters.Mappers.UserMapper;
import Easys.Easys.Adapters.Persistence.UserPersistence;
import Easys.Easys.Core.Model.User;
import Easys.Easys.Core.UseCases.User.UserCreate;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;



@Service
public class UserCreateImpl implements UserCreate {

    private final UserMapper map;
    private final BCryptPasswordEncoder passwordEncoder;
    private final UserPersistence userPersistence;

    public UserCreateImpl(
            UserMapper map,
            BCryptPasswordEncoder passwordEncoder,
            UserPersistence userPersistence) {
        this.map = map;
        this.passwordEncoder = passwordEncoder;
        this.userPersistence = userPersistence;
        
    }

    @Override
    public ResponseEntity<?> create(UserCreateDto userDto) {
        User user = map.toModel(userDto);
        if (userPersistence.findByEmail(user.getEmail()) != null) {
            return new ResponseEntity<>("User already exists", HttpStatus.CONFLICT);
        }
        user.setPasswordHash(passwordEncoder.encode(user.getPasswordHash()));
        return userPersistence.save(user);
    }

   
}
