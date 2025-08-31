package Easys.Easys.Adapters.Mappers;

import Easys.Easys.Adapters.Dtos.AppointmentDtos.AppointmentCreateDto;
import Easys.Easys.Adapters.Persistence.ProfessionalPersistence;
import Easys.Easys.Adapters.Persistence.ServicePersistence;
import Easys.Easys.Adapters.Persistence.UserPersistence;
import Easys.Easys.Core.Model.Appointment;
import Easys.Easys.Core.Model.Service;
import Easys.Easys.Core.Model.Enums.AppointmentStatus;


public class AppointmentMapper {
    public AppointmentMapper(
        UserPersistence userPersistence,
        ProfessionalPersistence professionalPersistence,
        ServicePersistence servicePersistence
    ) {
        this.userPersistence = userPersistence;
        this.professionalPersistence = professionalPersistence;
        this.servicePersistence = servicePersistence;
    }
    private final UserPersistence userPersistence;
    private final ProfessionalPersistence professionalPersistence;
    private final ServicePersistence servicePersistence;

    public Appointment toEntity(AppointmentCreateDto createDto) {

        Service service = servicePersistence.findById(createDto.serviceId());
        
        Appointment appointment = new Appointment();
        appointment.setClient(userPersistence.findById(createDto.clientId()));
        appointment.setProvider(professionalPersistence.findById(createDto.professionalId()));
        appointment.setService(service);
        appointment.setStartAppointmentTime(createDto.appointmentDateTime());
        appointment.setStatus(AppointmentStatus.PENDING);
        appointment.setEndAppointmentTime(createDto.appointmentDateTime().plusMinutes(service.getDuration()));
        return appointment;
    }
    
}
