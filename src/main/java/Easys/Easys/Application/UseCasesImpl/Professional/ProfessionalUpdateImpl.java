package Easys.Easys.Application.UseCasesImpl.Professional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import Easys.Easys.Adapters.Dtos.ProfessionalDtos.ProfessionalUpdateDto;
import Easys.Easys.Adapters.Persistence.ProfessionalPersistence;
import Easys.Easys.Adapters.Persistence.UserPersistence;
import Easys.Easys.Core.Model.Professional;
import Easys.Easys.Core.Model.User;
import Easys.Easys.Core.UseCases.Professional.ProfessionalUpdate;

import java.util.Optional;

@Service
public class ProfessionalUpdateImpl implements ProfessionalUpdate {
    
    private final ProfessionalPersistence professionalPersistence;
    private final UserPersistence userPersistence;
    
    public ProfessionalUpdateImpl(ProfessionalPersistence professionalPersistence, UserPersistence userPersistence) {
        this.professionalPersistence = professionalPersistence;
        this.userPersistence = userPersistence;
    }
    
    @Override
    public ResponseEntity<?> update(Long id, ProfessionalUpdateDto professionalUpdateDto) {
        Optional<Professional> existingProfessionalOpt = professionalPersistence.findByIdOptional(id);
        
        if (!existingProfessionalOpt.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        
        Professional existingProfessional = existingProfessionalOpt.get();
        User associatedUser = existingProfessional.getUser();
        
        // Update Professional fields
        existingProfessional.setCpf(professionalUpdateDto.cpf());
        existingProfessional.setProfessionalType(professionalUpdateDto.professionalType());
        existingProfessional.setProfessionalDescription(professionalUpdateDto.professionalDescription());
        
        // Update associated User fields
        associatedUser.setUsername(professionalUpdateDto.username());
        associatedUser.setEmail(professionalUpdateDto.email());
        associatedUser.setPhone(professionalUpdateDto.phone());
        associatedUser.setAddress(professionalUpdateDto.address());
        associatedUser.setCity(professionalUpdateDto.city());
        associatedUser.setState(professionalUpdateDto.state());
        associatedUser.setCountry(professionalUpdateDto.country());
        associatedUser.setZip(professionalUpdateDto.zip());
        
        try {
            userPersistence.update(associatedUser);
            return professionalPersistence.update(existingProfessional);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}