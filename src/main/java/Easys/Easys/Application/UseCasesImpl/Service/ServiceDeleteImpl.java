package Easys.Easys.Application.UseCasesImpl.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import Easys.Easys.Adapters.Persistence.ServicePersistence;
import Easys.Easys.Core.UseCases.Service.ServiceDelete;

@Service
public class ServiceDeleteImpl implements ServiceDelete {
    
    private final ServicePersistence servicePersistence;
    
    public ServiceDeleteImpl(ServicePersistence servicePersistence) {
        this.servicePersistence = servicePersistence;
    }
    
    @Override
    public ResponseEntity<?> delete(Long id) {
        if (!servicePersistence.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        
        return servicePersistence.delete(id);
    }
}