package Easys.Easys.Application.UseCasesImpl.Appointment;

import org.springframework.http.ResponseEntity;

import Easys.Easys.Adapters.Dtos.AppointmentDtos.AppointmentCreateDto;
import Easys.Easys.Adapters.Mappers.AppointmentMapper;
import Easys.Easys.Adapters.Persistence.AppointmentPersistence;
import Easys.Easys.Adapters.Persistence.PaymentPersistence;
import Easys.Easys.Core.Model.Appointment;
import Easys.Easys.Core.Model.Payment;
import Easys.Easys.Core.Model.Enums.PaymentStatus;

public class AppointmentCreateImpl {
    private final AppointmentMapper appointmentMapper;
    private final AppointmentPersistence appointmentPersistence;
    public AppointmentCreateImpl(AppointmentMapper appointmentMapper, AppointmentPersistence appointmentPersistence, PaymentPersistence paymentPersistence) {
        this.appointmentMapper = appointmentMapper;
        this.appointmentPersistence = appointmentPersistence;
        this.paymentPersistence = paymentPersistence;
    }
    private final PaymentPersistence paymentPersistence;
    public ResponseEntity<?> create(AppointmentCreateDto appointment) {
        
        Appointment appointmentEntity = appointmentMapper.toEntity(appointment);

        Payment payment = new Payment();
        payment.setAmount(appointmentEntity.getService().getPrice());
        payment.setStatus(PaymentStatus.PENDING);
        appointmentEntity.setPayment(payment);
        
        appointmentPersistence.create(appointmentEntity);
        paymentPersistence.create(payment);

        
        return ResponseEntity.ok().build();
    }
}
