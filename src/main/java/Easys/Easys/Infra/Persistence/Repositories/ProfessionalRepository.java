package Easys.Easys.Infra.Persistence.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import Easys.Easys.Core.Model.Professional;

public interface ProfessionalRepository extends JpaRepository<Professional, Long> {
    boolean existsByCpf(String cpf);
}