package Easys.Easys.Adapters.Dtos.AppointmentDtos;

import java.time.LocalDateTime;

public record AppointmentCreateDto(
    Long clientId,
    Long professionalId,
    Long serviceId,
    LocalDateTime appointmentDateTime
) {
    
}
