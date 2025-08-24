package Easys.Easys.Adapters.Persistence;

import org.springframework.http.ResponseEntity;

import Easys.Easys.Core.Model.Professional;
import Easys.Easys.Infra.Persistence.Repositories.ProfessionalRepository;
import org.springframework.stereotype.Component;


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

    
}
