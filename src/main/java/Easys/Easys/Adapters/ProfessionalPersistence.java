package Easys.Easys.Adapters;

import org.springframework.http.ResponseEntity;

import Easys.Easys.Adapters.Mappers.ProfessionalMapper;
import Easys.Easys.Core.Model.Professional;
import Easys.Easys.Infra.Persistence.Entities.UserEntity;
import Easys.Easys.Infra.Persistence.Repositories.ProfessionalRepository;



public class ProfessionalPersistence  {
    private final ProfessionalRepository professionalRepository;
    private final ProfessionalMapper map;

    public ProfessionalPersistence(ProfessionalRepository professionalRepository, ProfessionalMapper map) { 
        this.professionalRepository = professionalRepository;
        this.map = map;
    }

    public ResponseEntity<?> save(Professional professional, UserEntity user) {
        professionalRepository.save(map.toEntity(professional, user));
        return ResponseEntity.ok().build();
    }

    
}
