package Easys.Easys.Adapters.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Easys.Easys.Adapters.Dtos.ServiceDtos.ServiceCreateDto;

@RestController
@RequestMapping("/services")
public class ServiceController {
    @PostMapping("/create")
    public ResponseEntity<?> createService(@RequestBody ServiceCreateDto serviceCreateDto) {
        return ResponseEntity.ok().body(serviceCreateDto);
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllServices() {
        return ResponseEntity.ok().body("getAllServices");
    }

    @GetMapping("/getByProfessional/{id}")
    public ResponseEntity<?> getServiceByProfessional(@PathVariable Long id) {
        return ResponseEntity.ok().body("getServiceByProfessional");
    }


}
