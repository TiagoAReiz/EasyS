package Easys.Easys.Adapters.Mappers;

import org.springframework.stereotype.Component;

import Easys.Easys.Adapters.Dtos.ProfessionalDtos.ProfessionalCreateDto;
import Easys.Easys.Core.Model.Professional;
import Easys.Easys.Core.Model.User;
import Easys.Easys.Core.Model.Enums.Role;

@Component
public class ProfessionalMapper {
    public Professional toModel(ProfessionalCreateDto dto, User user){
        Professional professional = new Professional();
        professional.setCpf(dto.cpf());
        professional.setProfessionalType(dto.professionalType());
        professional.setProfessionalDescription(dto.professionalDescription());
        professional.setUser(user);
        return professional;
    }
    public User toUserModel(ProfessionalCreateDto dto){
        User user = new User();
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


    
}
