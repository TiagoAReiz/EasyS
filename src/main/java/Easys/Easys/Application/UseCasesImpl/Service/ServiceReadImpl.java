package Easys.Easys.Application.UseCasesImpl.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import Easys.Easys.Adapters.Persistence.ServicePersistence;
import Easys.Easys.Core.UseCases.Service.ServiceRead;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceReadImpl implements ServiceRead {
    
    private final ServicePersistence servicePersistence;
    
    public ServiceReadImpl(ServicePersistence servicePersistence) {
        this.servicePersistence = servicePersistence;
    }
    
    @Override
    public ResponseEntity<Easys.Easys.Core.Model.Service> findById(Long id) {
        Optional<Easys.Easys.Core.Model.Service> service = servicePersistence.findByIdOptional(id);
        if (service.isPresent()) {
            return ResponseEntity.ok(service.get());
        }
        return ResponseEntity.notFound().build();
    }
    
    @Override
    public ResponseEntity<List<Easys.Easys.Core.Model.Service>> findAll() {
        List<Easys.Easys.Core.Model.Service> services = servicePersistence.findAll();
        return ResponseEntity.ok(services);
    }
}