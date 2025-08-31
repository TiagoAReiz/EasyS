package Easys.Easys.Core.UseCases.Appointment;

import org.springframework.http.ResponseEntity;

import Easys.Easys.Adapters.Dtos.AppointmentDtos.AppointmentUpdateDto;

public interface AppointmentUpdate {
    ResponseEntity<?> update(Long id, AppointmentUpdateDto appointmentUpdateDto);
}