package Easys.Easys.Infra.Persistence.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import Easys.Easys.Core.Model.User;


public interface UserRepository extends JpaRepository<User, Long> {
    public User findByUsername(String username);
    public UserDetails findByEmail(String email);
}
