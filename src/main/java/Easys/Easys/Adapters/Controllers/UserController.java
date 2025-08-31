package Easys.Easys.Adapters.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import Easys.Easys.Adapters.Dtos.UserDtos.UserUpdateDto;
import Easys.Easys.Core.Model.User;
import Easys.Easys.Core.UseCases.User.UserRead;
import Easys.Easys.Core.UseCases.User.UserUpdate;
import Easys.Easys.Core.UseCases.User.UserDelete;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    
    private final UserRead userRead;
    private final UserUpdate userUpdate;
    private final UserDelete userDelete;
    
    public UserController(UserRead userRead, UserUpdate userUpdate, UserDelete userDelete) {
        this.userRead = userRead;
        this.userUpdate = userUpdate;
        this.userDelete = userDelete;
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        return userRead.findById(id);
    }
    
    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        return userRead.findAll();
    }
    
    @GetMapping("/email/{email}")
    public ResponseEntity<User> findByEmail(@PathVariable String email) {
        return userRead.findByEmail(email);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody UserUpdateDto userUpdateDto) {
        return userUpdate.update(id, userUpdateDto);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return userDelete.delete(id);
    }
}