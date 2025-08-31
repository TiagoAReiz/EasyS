package Easys.Easys.Core.UseCases.User;

import org.springframework.http.ResponseEntity;

public interface UserDelete {
    ResponseEntity<?> delete(Long id);
}