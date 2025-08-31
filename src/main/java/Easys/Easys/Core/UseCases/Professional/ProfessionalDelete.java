package Easys.Easys.Core.UseCases.Professional;

import org.springframework.http.ResponseEntity;

public interface ProfessionalDelete {
    ResponseEntity<?> delete(Long id);
}