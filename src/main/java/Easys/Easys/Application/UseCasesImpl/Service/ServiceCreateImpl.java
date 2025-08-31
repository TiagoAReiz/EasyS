package Easys.Easys.Application.UseCasesImpl.Service;

import org.springframework.http.ResponseEntity;

import Easys.Easys.Adapters.Dtos.ServiceDtos.ServiceCreateDto;
import Easys.Easys.Adapters.Mappers.ServiceMapper;
import Easys.Easys.Adapters.Persistence.ServicePersistence;
import Easys.Easys.Core.Model.Service;
import Easys.Easys.Core.UseCases.Service.ServiceCreate;

public class ServiceCreateImpl implements ServiceCreate {

    private final ServicePersistence servicePersistence;
    private final ServiceMapper serviceMapper;

    public ServiceCreateImpl(ServicePersistence servicePersistence, ServiceMapper serviceMapper) {
        this.servicePersistence = servicePersistence;
        this.serviceMapper = serviceMapper;
    }


    
    @Override
    public ResponseEntity<?> create(ServiceCreateDto serviceCreateDto) {
        Service service = serviceMapper.toModel(serviceCreateDto);
        servicePersistence.save(service);
        return ResponseEntity.ok().build();
    }
}
