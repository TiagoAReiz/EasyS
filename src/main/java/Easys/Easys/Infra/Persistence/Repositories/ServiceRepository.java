package Easys.Easys.Infra.Persistence.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import Easys.Easys.Core.Model.Service;

public interface ServiceRepository extends JpaRepository<Service, Long> {

    
}
