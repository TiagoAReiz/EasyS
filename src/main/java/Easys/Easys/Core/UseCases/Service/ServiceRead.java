package Easys.Easys.Core.UseCases.Service;

import org.springframework.http.ResponseEntity;

import Easys.Easys.Core.Model.Service;

import java.util.List;

public interface ServiceRead {
    ResponseEntity<Service> findById(Long id);
    ResponseEntity<List<Service>> findAll();
}