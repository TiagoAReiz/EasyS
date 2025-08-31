package Easys.Easys.Application.UseCasesImpl.Professional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import Easys.Easys.Adapters.Persistence.ProfessionalPersistence;
import Easys.Easys.Core.UseCases.Professional.ProfessionalDelete;

@Service
public class ProfessionalDeleteImpl implements ProfessionalDelete {
    
    private final ProfessionalPersistence professionalPersistence;
    
    public ProfessionalDeleteImpl(ProfessionalPersistence professionalPersistence) {
        this.professionalPersistence = professionalPersistence;
    }
    
    @Override
    public ResponseEntity<?> delete(Long id) {
        if (!professionalPersistence.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        
        return professionalPersistence.delete(id);
    }
}