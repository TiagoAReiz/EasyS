package Easys.Easys.Core.UseCases.Professional;

import org.springframework.http.ResponseEntity;

import Easys.Easys.Core.Model.Professional;

import java.util.List;

public interface ProfessionalRead {
    ResponseEntity<Professional> findById(Long id);
    ResponseEntity<List<Professional>> findAll();
    ResponseEntity<Professional> findByCpf(String cpf);
}