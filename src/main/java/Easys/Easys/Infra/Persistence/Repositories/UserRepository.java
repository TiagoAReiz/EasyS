package Easys.Easys.Infra.Persistence.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import Easys.Easys.Infra.Persistence.Entities.UserEntity;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    public UserEntity findByUsername(String username);
    public UserDetails findByEmail(String email);
}
