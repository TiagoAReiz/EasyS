package Easys.Easys.Core.UseCases.Service;

import org.springframework.http.ResponseEntity;

public interface ServiceDelete {
    ResponseEntity<?> delete(Long id);
}