package Easys.Easys.Application.UseCasesImpl.Appointment;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import Easys.Easys.Adapters.Dtos.AppointmentDtos.AppointmentUpdateDto;
import Easys.Easys.Adapters.Persistence.AppointmentPersistence;
import Easys.Easys.Adapters.Persistence.ProfessionalPersistence;
import Easys.Easys.Adapters.Persistence.ServicePersistence;
import Easys.Easys.Adapters.Persistence.UserPersistence;
import Easys.Easys.Core.Model.Appointment;
import Easys.Easys.Core.UseCases.Appointment.AppointmentUpdate;

import java.util.Optional;

@Service
public class AppointmentUpdateImpl implements AppointmentUpdate {
    
    private final AppointmentPersistence appointmentPersistence;
    private final UserPersistence userPersistence;
    private final ProfessionalPersistence professionalPersistence;
    private final ServicePersistence servicePersistence;
    
    public AppointmentUpdateImpl(
            AppointmentPersistence appointmentPersistence,
            UserPersistence userPersistence,
            ProfessionalPersistence professionalPersistence,
            ServicePersistence servicePersistence) {
        this.appointmentPersistence = appointmentPersistence;
        this.userPersistence = userPersistence;
        this.professionalPersistence = professionalPersistence;
        this.servicePersistence = servicePersistence;
    }
    
    @Override
    public ResponseEntity<?> update(Long id, AppointmentUpdateDto appointmentUpdateDto) {
        Optional<Appointment> existingAppointmentOpt = appointmentPersistence.findByIdOptional(id);
        
        if (!existingAppointmentOpt.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        
        Appointment existingAppointment = existingAppointmentOpt.get();
        
        try {
            // Update fields from DTO
            if (appointmentUpdateDto.clientId() != null) {
                existingAppointment.setClient(userPersistence.findById(appointmentUpdateDto.clientId()));
            }
            
            if (appointmentUpdateDto.professionalId() != null) {
                existingAppointment.setProvider(professionalPersistence.findById(appointmentUpdateDto.professionalId()));
            }
            
            if (appointmentUpdateDto.serviceId() != null) {
                Easys.Easys.Core.Model.Service service = servicePersistence.findById(appointmentUpdateDto.serviceId());
                existingAppointment.setService(service);
                // Update end time based on new service duration
                existingAppointment.setEndAppointmentTime(
                    appointmentUpdateDto.appointmentDateTime().plusMinutes(service.getDuration())
                );
            }
            
            if (appointmentUpdateDto.appointmentDateTime() != null) {
                existingAppointment.setStartAppointmentTime(appointmentUpdateDto.appointmentDateTime());
                // Update end time if service exists
                if (existingAppointment.getService() != null) {
                    existingAppointment.setEndAppointmentTime(
                        appointmentUpdateDto.appointmentDateTime().plusMinutes(existingAppointment.getService().getDuration())
                    );
                }
            }
            
            if (appointmentUpdateDto.status() != null) {
                existingAppointment.setStatus(appointmentUpdateDto.status());
            }
            
            return appointmentPersistence.update(existingAppointment);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}