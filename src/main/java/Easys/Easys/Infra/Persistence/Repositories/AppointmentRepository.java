package Easys.Easys.Infra.Persistence.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import Easys.Easys.Core.Model.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    
}
