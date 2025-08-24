package Easys.Easys.Core.UseCases.Professional;

import org.springframework.http.ResponseEntity;

import Easys.Easys.Adapters.Dtos.ProfessionalDtos.ProfessionalCreateDto;

public interface ProfessionalCreate {
    public ResponseEntity<?> createProfessional(ProfessionalCreateDto proDto);
    
} 