package Easys.Easys.Adapters;

import org.springframework.http.ResponseEntity;

import Easys.Easys.Adapters.Mappers.ProfessionalMapper;
import Easys.Easys.Infra.Persistence.Entities.ProfessionalEntity;
import Easys.Easys.Infra.Persistence.Repositories.ProfessionalRepository;
import org.springframework.stereotype.Component;


@Component
public class ProfessionalPersistence  {
    private final ProfessionalRepository professionalRepository;


    public ProfessionalPersistence(ProfessionalRepository professionalRepository) { 
        this.professionalRepository = professionalRepository;

    }

    public ResponseEntity<?> save(ProfessionalEntity professional) {
        professionalRepository.save(professional);
        return ResponseEntity.ok().build();
    }
    public boolean existsByCpf(String cpf) {
        return professionalRepository.existsByCpf(cpf);
    }

    
}
