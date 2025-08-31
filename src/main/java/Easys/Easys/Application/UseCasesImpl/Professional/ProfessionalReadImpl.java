package Easys.Easys.Application.UseCasesImpl.Professional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import Easys.Easys.Adapters.Persistence.ProfessionalPersistence;
import Easys.Easys.Core.Model.Professional;
import Easys.Easys.Core.UseCases.Professional.ProfessionalRead;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessionalReadImpl implements ProfessionalRead {
    
    private final ProfessionalPersistence professionalPersistence;
    
    public ProfessionalReadImpl(ProfessionalPersistence professionalPersistence) {
        this.professionalPersistence = professionalPersistence;
    }
    
    @Override
    public ResponseEntity<Professional> findById(Long id) {
        Optional<Professional> professional = professionalPersistence.findByIdOptional(id);
        if (professional.isPresent()) {
            return ResponseEntity.ok(professional.get());
        }
        return ResponseEntity.notFound().build();
    }
    
    @Override
    public ResponseEntity<List<Professional>> findAll() {
        List<Professional> professionals = professionalPersistence.findAll();
        return ResponseEntity.ok(professionals);
    }
    
    @Override
    public ResponseEntity<Professional> findByCpf(String cpf) {
        if (professionalPersistence.existsByCpf(cpf)) {
            // Note: We need to add a findByCpf method to ProfessionalPersistence
            // For now, we'll return a not implemented response
            return ResponseEntity.status(501).build(); // Not Implemented
        }
        return ResponseEntity.notFound().build();
    }
}