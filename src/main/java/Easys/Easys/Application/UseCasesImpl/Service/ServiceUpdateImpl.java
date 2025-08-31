package Easys.Easys.Application.UseCasesImpl.Service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import Easys.Easys.Adapters.Dtos.ServiceDtos.ServiceUpdateDto;
import Easys.Easys.Adapters.Persistence.ServicePersistence;
import Easys.Easys.Core.UseCases.Service.ServiceUpdate;

import java.util.Optional;

@Service
public class ServiceUpdateImpl implements ServiceUpdate {
    
    private final ServicePersistence servicePersistence;
    
    public ServiceUpdateImpl(ServicePersistence servicePersistence) {
        this.servicePersistence = servicePersistence;
    }
    
    @Override
    public ResponseEntity<?> update(Long id, ServiceUpdateDto serviceUpdateDto) {
        Optional<Easys.Easys.Core.Model.Service> existingServiceOpt = servicePersistence.findByIdOptional(id);
        
        if (!existingServiceOpt.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        
        Easys.Easys.Core.Model.Service existingService = existingServiceOpt.get();
        
        // Update fields from DTO
        existingService.setName(serviceUpdateDto.name());
        existingService.setDescription(serviceUpdateDto.description());
        existingService.setPrice(serviceUpdateDto.price());
        existingService.setCategory(serviceUpdateDto.category());
        existingService.setDuration(serviceUpdateDto.duration());
        existingService.setRating(serviceUpdateDto.rating());
        existingService.setProvider(serviceUpdateDto.provider());
        existingService.setLocation(serviceUpdateDto.location());
        existingService.setContact(serviceUpdateDto.contact());
        existingService.setImage(serviceUpdateDto.image());
        
        try {
            return servicePersistence.update(existingService);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}