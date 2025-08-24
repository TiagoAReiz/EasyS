package Easys.Easys.Core.UseCases.Service;

import org.springframework.http.ResponseEntity;

import Easys.Easys.Adapters.Dtos.ServiceDtos.ServiceCreateDto;

public interface ServiceCreate {
    ResponseEntity<?> create(ServiceCreateDto serviceCreateDto);
    
}
