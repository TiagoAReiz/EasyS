package Easys.Easys.Adapters.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import Easys.Easys.Adapters.Dtos.ProfessionalDtos.ProfessionalUpdateDto;
import Easys.Easys.Core.Model.Professional;
import Easys.Easys.Core.UseCases.Professional.ProfessionalRead;
import Easys.Easys.Core.UseCases.Professional.ProfessionalUpdate;
import Easys.Easys.Core.UseCases.Professional.ProfessionalDelete;

import java.util.List;

@RestController
@RequestMapping("/professionals")
public class ProfessionalController {
    
    private final ProfessionalRead professionalRead;
    private final ProfessionalUpdate professionalUpdate;
    private final ProfessionalDelete professionalDelete;
    
    public ProfessionalController(ProfessionalRead professionalRead, 
                                ProfessionalUpdate professionalUpdate, 
                                ProfessionalDelete professionalDelete) {
        this.professionalRead = professionalRead;
        this.professionalUpdate = professionalUpdate;
        this.professionalDelete = professionalDelete;
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Professional> findById(@PathVariable Long id) {
        return professionalRead.findById(id);
    }
    
    @GetMapping
    public ResponseEntity<List<Professional>> findAll() {
        return professionalRead.findAll();
    }
    
    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<Professional> findByCpf(@PathVariable String cpf) {
        return professionalRead.findByCpf(cpf);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ProfessionalUpdateDto professionalUpdateDto) {
        return professionalUpdate.update(id, professionalUpdateDto);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return professionalDelete.delete(id);
    }
}