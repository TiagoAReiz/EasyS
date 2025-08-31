package Easys.Easys.Adapters.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import Easys.Easys.Adapters.Dtos.AppointmentDtos.AppointmentCreateDto;
import Easys.Easys.Adapters.Dtos.AppointmentDtos.AppointmentUpdateDto;
import Easys.Easys.Core.Model.Appointment;
import Easys.Easys.Core.UseCases.Appointment.AppointmentCreate;
import Easys.Easys.Core.UseCases.Appointment.AppointmentRead;
import Easys.Easys.Core.UseCases.Appointment.AppointmentUpdate;
import Easys.Easys.Core.UseCases.Appointment.AppointmentDelete;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
    
    private final AppointmentCreate appointmentCreate;
    private final AppointmentRead appointmentRead;
    private final AppointmentUpdate appointmentUpdate;
    private final AppointmentDelete appointmentDelete;
    
    public AppointmentController(AppointmentCreate appointmentCreate, AppointmentRead appointmentRead,
                               AppointmentUpdate appointmentUpdate, AppointmentDelete appointmentDelete) {
        this.appointmentCreate = appointmentCreate;
        this.appointmentRead = appointmentRead;
        this.appointmentUpdate = appointmentUpdate;
        this.appointmentDelete = appointmentDelete;
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> createAppointment(@RequestBody AppointmentCreateDto appointmentCreateDto) {
        return appointmentCreate.create(appointmentCreateDto);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Appointment> findById(@PathVariable Long id) {
        return appointmentRead.findById(id);
    }
    
    @GetMapping
    public ResponseEntity<List<Appointment>> findAll() {
        return appointmentRead.findAll();
    }
    
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Appointment>> findByUserId(@PathVariable Long userId) {
        return appointmentRead.findByUserId(userId);
    }
    
    @GetMapping("/professional/{professionalId}")
    public ResponseEntity<List<Appointment>> findByProfessionalId(@PathVariable Long professionalId) {
        return appointmentRead.findByProfessionalId(professionalId);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody AppointmentUpdateDto appointmentUpdateDto) {
        return appointmentUpdate.update(id, appointmentUpdateDto);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return appointmentDelete.delete(id);
    }
}
