package Easys.Easys.Core.UseCases.Service;

import org.springframework.http.ResponseEntity;

import Easys.Easys.Adapters.Dtos.ServiceDtos.ServiceUpdateDto;

public interface ServiceUpdate {
    ResponseEntity<?> update(Long id, ServiceUpdateDto serviceUpdateDto);
}