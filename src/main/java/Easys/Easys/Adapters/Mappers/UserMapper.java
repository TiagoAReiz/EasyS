package Easys.Easys.Adapters.Mappers;

import Easys.Easys.Adapters.Dtos.UserDtos.UserCreateDto;
import Easys.Easys.Core.Model.User;
import Easys.Easys.Infra.Persistence.Entities.UserEntity;

import java.time.LocalDateTime;

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
        public UserEntity toEntity(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(user.getId());
        userEntity.setUsername(user.getUsername());
        userEntity.setEmail(user.getEmail());
        userEntity.setPhone(user.getPhone());
        userEntity.setPasswordHash(user.getPasswordHash());
        userEntity.setAddress(user.getAddress());
        userEntity.setCity(user.getCity());
        userEntity.setState(user.getState());
        userEntity.setCountry(user.getCountry());
        userEntity.setZip(user.getZip());
        userEntity.setCreatedAt(user.getCreatedAt() != null ? user.getCreatedAt() : LocalDateTime.now());
        userEntity.setUpdatedAt(user.getUpdatedAt());
        return userEntity;
    }
    public User toUser(UserEntity userEntity) {
        User user = new User();
        user.setId(userEntity.getId());
        user.setUsername(userEntity.getUsername());
        user.setEmail(userEntity.getEmail());
        user.setPhone(userEntity.getPhone());
        user.setPasswordHash(userEntity.getPasswordHash());
        user.setAddress(userEntity.getAddress());
        user.setCity(userEntity.getCity());
        user.setState(userEntity.getState());
        user.setCountry(userEntity.getCountry());
        user.setZip(userEntity.getZip());
        user.setCreatedAt(userEntity.getCreatedAt());
        user.setUpdatedAt(userEntity.getUpdatedAt());
        return user;
    }
}
