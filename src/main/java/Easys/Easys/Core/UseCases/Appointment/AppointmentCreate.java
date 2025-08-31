package Easys.Easys.Core.UseCases.Appointment;

import org.springframework.http.ResponseEntity;

import Easys.Easys.Adapters.Dtos.AppointmentDtos.AppointmentCreateDto;

public interface AppointmentCreate {

    ResponseEntity<?> create(AppointmentCreateDto appointment);
}
