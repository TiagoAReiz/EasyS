package Easys.Easys.Adapters.Persistence;

import org.springframework.http.ResponseEntity;

import Easys.Easys.Core.Model.Service;
import Easys.Easys.Infra.Persistence.Repositories.ServiceRepository;

public class ServicePersistence {
    private final ServiceRepository serviceRepository;

    public ServicePersistence(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }
    public ResponseEntity<?> save(Service service) {
        serviceRepository.save(service);
        return ResponseEntity.ok().build();

    }

    
}
