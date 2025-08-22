package Easys.Easys.Infra.Persistence.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import Easys.Easys.Infra.Persistence.Entities.ProfessionalEntity;

public interface ProfessionalRepository extends JpaRepository<ProfessionalEntity, Long> {
    boolean existsByCpf(String cpf);
}