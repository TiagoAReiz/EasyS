package Easys.Easys.Adapters.Mappers;

import org.springframework.stereotype.Component;

import Easys.Easys.Adapters.Dtos.ProfessionalDtos.ProfessionalCreateDto;
import Easys.Easys.Core.Model.Professional;
import Easys.Easys.Core.Model.User;
import Easys.Easys.Core.Model.Enums.Role;
import Easys.Easys.Infra.Persistence.Entities.ProfessionalEntity;
import Easys.Easys.Infra.Persistence.Entities.UserEntity;

@Component
public class ProfessionalMapper {
    public Professional toModel(ProfessionalCreateDto dto){
        Professional professional = new Professional();
        professional.setCpf(dto.cpf());
        professional.setProfessionalType(dto.professionalType());
        professional.setProfessionalDescription(dto.professionalDescription());
        return professional;
    }
    public UserEntity toUserEntity(ProfessionalCreateDto dto){
        UserEntity user = new UserEntity();
        user.setUsername(dto.username());
        user.setEmail(dto.email());
        user.setPhone(dto.phone());
        user.setPasswordHash(dto.password());
        user.setAddress(dto.address());
        user.setCity(dto.city());
        user.setState(dto.state());
        user.setCountry(dto.country());
        user.setZip(dto.zip());
        user.setRole(Role.PROFFESIONAL);
        return user;    

    }
    public ProfessionalEntity toEntity(Professional professional, UserEntity userEntity) {
        ProfessionalEntity entity = new ProfessionalEntity();
        entity.setUser(userEntity);
        entity.setCpf(professional.getCpf());
        entity.setProfessionalType(professional.getProfessionalType());
        entity.setProfessionalDescription(professional.getProfessionalDescription());
        return entity;
    }

    public Professional toDomain(ProfessionalEntity entity) {
        Professional professional = new Professional();
        professional.setCpf(entity.getCpf());
        professional.setProfessionalType(entity.getProfessionalType());
        professional.setProfessionalDescription(entity.getProfessionalDescription());
        return professional;
    }

    
}
