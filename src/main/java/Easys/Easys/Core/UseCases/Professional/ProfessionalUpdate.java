package Easys.Easys.Core.UseCases.Professional;

import org.springframework.http.ResponseEntity;

import Easys.Easys.Adapters.Dtos.ProfessionalDtos.ProfessionalUpdateDto;

public interface ProfessionalUpdate {
    ResponseEntity<?> update(Long id, ProfessionalUpdateDto professionalUpdateDto);
}