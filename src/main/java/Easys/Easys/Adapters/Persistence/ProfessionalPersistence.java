package Easys.Easys.Adapters.Persistence;

import org.springframework.http.ResponseEntity;

import Easys.Easys.Core.Model.Professional;
import Easys.Easys.Infra.Persistence.Repositories.ProfessionalRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class ProfessionalPersistence  {
    private final ProfessionalRepository professionalRepository;


    public ProfessionalPersistence(ProfessionalRepository professionalRepository) { 
        this.professionalRepository = professionalRepository;

    }

    public ResponseEntity<?> save(Professional professional) {
        professionalRepository.save(professional);
        return ResponseEntity.ok().build();
    }
    public boolean existsByCpf(String cpf) {
        return professionalRepository.existsByCpf(cpf);
    }
    public Professional findById(Long id) {
        return professionalRepository.findById(id).get();
    }
    
    public Optional<Professional> findByIdOptional(Long id) {
        return professionalRepository.findById(id);
    }
    
    public List<Professional> findAll() {
        return professionalRepository.findAll();
    }
    
    public ResponseEntity<?> update(Professional professional) {
        professionalRepository.save(professional);
        return ResponseEntity.ok().build();
    }
    
    public ResponseEntity<?> delete(Long id) {
        professionalRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
    
    public boolean existsById(Long id) {
        return professionalRepository.existsById(id);
    }
}
