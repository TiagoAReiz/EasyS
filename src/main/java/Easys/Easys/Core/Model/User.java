package Easys.Easys.Core.Model;

import Easys.Easys.Core.Model.Enums.Role;

import java.time.LocalDateTime;


public class User  {
    private String username;
    private String email;
    private String phone;
    private String passwordHash;
    private String address;
    private String city;
    private String state;
    private String country;
    private String zip; 
    private Role role;
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public User( String name, String email, String phone, String passwordHash, Role role, String address, String city, String state, String country, String zip, LocalDateTime createdAt, LocalDateTime updatedAt) {

        this.username = name;
        this.email = email;
        this.phone = phone;
        this.passwordHash = passwordHash;
        this.role = Role.USER;
        this.address = null;
        this.city = null;
        this.state = null;
        this.country = null;
        this.zip = null;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = null;
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
