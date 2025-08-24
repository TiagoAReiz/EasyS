package Easys.Easys.Core.UseCases;

import org.springframework.http.ResponseEntity;

import Easys.Easys.Adapters.Dtos.ProfessionalDtos.ProfessionalCreateDto;

public interface ProfessionalUseCase {
    public ResponseEntity<?> createProfessional(ProfessionalCreateDto proDto);
    
} 