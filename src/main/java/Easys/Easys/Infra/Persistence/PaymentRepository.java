package Easys.Easys.Infra.Persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import Easys.Easys.Core.Model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    
}
