package Easys.Easys.Adapters.Dtos.AppointmentDtos;

import java.time.LocalDateTime;

import Easys.Easys.Core.Model.Enums.AppointmentStatus;

public record AppointmentUpdateDto(
    Long clientId,
    Long professionalId,
    Long serviceId,
    LocalDateTime appointmentDateTime,
    AppointmentStatus status
) {
    
}