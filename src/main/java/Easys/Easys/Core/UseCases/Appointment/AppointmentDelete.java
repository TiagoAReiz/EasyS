package Easys.Easys.Core.UseCases.Appointment;

import org.springframework.http.ResponseEntity;

public interface AppointmentDelete {
    ResponseEntity<?> delete(Long id);
}