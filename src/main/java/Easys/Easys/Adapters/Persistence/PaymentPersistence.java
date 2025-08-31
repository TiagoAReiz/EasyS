package Easys.Easys.Adapters.Persistence;

import Easys.Easys.Core.Model.Payment;
import Easys.Easys.Infra.Persistence.PaymentRepository;

public class PaymentPersistence {
    public PaymentPersistence(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }
    private final PaymentRepository paymentRepository;

    public Payment create(Payment payment) {
        return paymentRepository.save(payment);
    }

    
}
