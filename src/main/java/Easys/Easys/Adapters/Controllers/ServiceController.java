package Easys.Easys.Adapters.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import Easys.Easys.Adapters.Dtos.ServiceDtos.ServiceCreateDto;
import Easys.Easys.Adapters.Dtos.ServiceDtos.ServiceUpdateDto;
import Easys.Easys.Core.Model.Service;
import Easys.Easys.Core.UseCases.Service.ServiceCreate;
import Easys.Easys.Core.UseCases.Service.ServiceRead;
import Easys.Easys.Core.UseCases.Service.ServiceUpdate;
import Easys.Easys.Core.UseCases.Service.ServiceDelete;

import java.util.List;

@RestController
@RequestMapping("/services")
public class ServiceController {
    
    private final ServiceCreate serviceCreate;
    private final ServiceRead serviceRead;
    private final ServiceUpdate serviceUpdate;
    private final ServiceDelete serviceDelete;
    
    public ServiceController(ServiceCreate serviceCreate, ServiceRead serviceRead, 
                           ServiceUpdate serviceUpdate, ServiceDelete serviceDelete) {
        this.serviceCreate = serviceCreate;
        this.serviceRead = serviceRead;
        this.serviceUpdate = serviceUpdate;
        this.serviceDelete = serviceDelete;
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> createService(@RequestBody ServiceCreateDto serviceCreateDto) {
        return serviceCreate.create(serviceCreateDto);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Service> findById(@PathVariable Long id) {
        return serviceRead.findById(id);
    }
    
    @GetMapping
    public ResponseEntity<List<Service>> findAll() {
        return serviceRead.findAll();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ServiceUpdateDto serviceUpdateDto) {
        return serviceUpdate.update(id, serviceUpdateDto);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return serviceDelete.delete(id);
    }
}
