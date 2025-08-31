package Easys.Easys.Core.UseCases.Appointment;

import org.springframework.http.ResponseEntity;

import Easys.Easys.Core.Model.Appointment;

import java.util.List;

public interface AppointmentRead {
    ResponseEntity<Appointment> findById(Long id);
    ResponseEntity<List<Appointment>> findAll();
    ResponseEntity<List<Appointment>> findByUserId(Long userId);
    ResponseEntity<List<Appointment>> findByProfessionalId(Long professionalId);
}