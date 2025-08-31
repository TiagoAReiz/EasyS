package Easys.Easys.Adapters.Persistence;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import Easys.Easys.Core.Model.Appointment;
import Easys.Easys.Infra.Persistence.Repositories.AppointmentRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class AppointmentPersistence {
    private final AppointmentRepository appointmentRepository;
    
    public AppointmentPersistence(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public Appointment create(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }
    
    public Appointment findById(Long id) {
        return appointmentRepository.findById(id).get();
    }
    
    public Optional<Appointment> findByIdOptional(Long id) {
        return appointmentRepository.findById(id);
    }
    
    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }
    
    public ResponseEntity<?> update(Appointment appointment) {
        appointmentRepository.save(appointment);
        return ResponseEntity.ok().build();
    }
    
    public ResponseEntity<?> delete(Long id) {
        appointmentRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
    
    public boolean existsById(Long id) {
        return appointmentRepository.existsById(id);
    }
}
