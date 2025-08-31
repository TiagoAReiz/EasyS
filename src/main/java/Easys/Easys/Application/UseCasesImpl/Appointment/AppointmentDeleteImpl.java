package Easys.Easys.Application.UseCasesImpl.Appointment;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import Easys.Easys.Adapters.Persistence.AppointmentPersistence;
import Easys.Easys.Core.UseCases.Appointment.AppointmentDelete;

@Service
public class AppointmentDeleteImpl implements AppointmentDelete {
    
    private final AppointmentPersistence appointmentPersistence;
    
    public AppointmentDeleteImpl(AppointmentPersistence appointmentPersistence) {
        this.appointmentPersistence = appointmentPersistence;
    }
    
    @Override
    public ResponseEntity<?> delete(Long id) {
        if (!appointmentPersistence.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        
        return appointmentPersistence.delete(id);
    }
}