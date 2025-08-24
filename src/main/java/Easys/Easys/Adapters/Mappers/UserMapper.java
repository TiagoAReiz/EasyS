package Easys.Easys.Adapters.Mappers;

import Easys.Easys.Adapters.Dtos.UserDtos.UserCreateDto;
import Easys.Easys.Core.Model.User;


import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User toModel(UserCreateDto userDto) {
        User user = new User();
        user.setUsername(userDto.username());
        user.setEmail(userDto.email());
        user.setPasswordHash(userDto.password());
        user.setPhone(userDto.phone());
        user.setAddress(userDto.address());
        user.setCity(userDto.city());
        user.setState(userDto.state());
        user.setCountry(userDto.country());
        user.setZip(userDto.zip());
        return user;
    }

}
