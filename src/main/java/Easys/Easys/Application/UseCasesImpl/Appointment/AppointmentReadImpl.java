package Easys.Easys.Application.UseCasesImpl.Appointment;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import Easys.Easys.Adapters.Persistence.AppointmentPersistence;
import Easys.Easys.Core.Model.Appointment;
import Easys.Easys.Core.UseCases.Appointment.AppointmentRead;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentReadImpl implements AppointmentRead {
    
    private final AppointmentPersistence appointmentPersistence;
    
    public AppointmentReadImpl(AppointmentPersistence appointmentPersistence) {
        this.appointmentPersistence = appointmentPersistence;
    }
    
    @Override
    public ResponseEntity<Appointment> findById(Long id) {
        Optional<Appointment> appointment = appointmentPersistence.findByIdOptional(id);
        if (appointment.isPresent()) {
            return ResponseEntity.ok(appointment.get());
        }
        return ResponseEntity.notFound().build();
    }
    
    @Override
    public ResponseEntity<List<Appointment>> findAll() {
        List<Appointment> appointments = appointmentPersistence.findAll();
        return ResponseEntity.ok(appointments);
    }
    
    @Override
    public ResponseEntity<List<Appointment>> findByUserId(Long userId) {
        // Note: We need to add a findByUserId method to AppointmentRepository and AppointmentPersistence
        // For now, we'll return a not implemented response
        return ResponseEntity.status(501).build(); // Not Implemented
    }
    
    @Override
    public ResponseEntity<List<Appointment>> findByProfessionalId(Long professionalId) {
        // Note: We need to add a findByProfessionalId method to AppointmentRepository and AppointmentPersistence
        // For now, we'll return a not implemented response
        return ResponseEntity.status(501).build(); // Not Implemented
    }
}