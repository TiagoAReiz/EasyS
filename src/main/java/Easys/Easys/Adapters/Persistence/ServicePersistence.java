package Easys.Easys.Adapters.Persistence;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import Easys.Easys.Core.Model.Service;
import Easys.Easys.Infra.Persistence.Repositories.ServiceRepository;

import java.util.List;
import java.util.Optional;

@Component
public class ServicePersistence {
    private final ServiceRepository serviceRepository;

    public ServicePersistence(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }
    public ResponseEntity<?> save(Service service) {
        serviceRepository.save(service);
        return ResponseEntity.ok().build();

    }
    public Service findById(Long id) {
        return serviceRepository.findById(id).get();
    }
    
    public Optional<Service> findByIdOptional(Long id) {
        return serviceRepository.findById(id);
    }
    
    public List<Service> findAll() {
        return serviceRepository.findAll();
    }
    
    public ResponseEntity<?> update(Service service) {
        serviceRepository.save(service);
        return ResponseEntity.ok().build();
    }
    
    public ResponseEntity<?> delete(Long id) {
        serviceRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
    
    public boolean existsById(Long id) {
        return serviceRepository.existsById(id);
    }
}
