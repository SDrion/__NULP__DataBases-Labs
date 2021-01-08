package com.polotskyi.model.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "passport_number")
    private String passportNumber;

    @Column(name = "driver_license_number")
    private String driverLicenseNumber;

    @Column(name = "status")
    private String status;

    @Column(name = "password_sha256")
    private String passwordSha256;

    @OneToMany(mappedBy = "userByUserId")
    private Collection<Fine> finesById;

    @OneToMany(mappedBy = "userByUserId")
    private Collection<Rent> rentsById;

    public User() {
    }

    public User(String firstName, String lastName, String phoneNumber, String email, String passportNumber, String driverLicenseNumber, String status, String passwordSha256) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.passportNumber = passportNumber;
        this.driverLicenseNumber = driverLicenseNumber;
        this.status = status;
        this.passwordSha256 = passwordSha256;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getDriverLicenseNumber() {
        return driverLicenseNumber;
    }

    public void setDriverLicenseNumber(String driverLicenseNumber) {
        this.driverLicenseNumber = driverLicenseNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPasswordSha256() {
        return passwordSha256;
    }

    public void setPasswordSha256(String passwordSha256) {
        this.passwordSha256 = passwordSha256;
    }

    public Collection<Fine> getFinesById() {
        return finesById;
    }

    public void setFinesById(Collection<Fine> finesById) {
        this.finesById = finesById;
    }

    public Collection<Rent> getRentsById() {
        return rentsById;
    }

    public void setRentsById(Collection<Rent> rentsById) {
        this.rentsById = rentsById;
    }

    @Override
    public String toString() {
        return "\n\n{id=" + id +
                ", \nfirstName='" + firstName + '\'' +
                ", \nlastName='" + lastName + '\'' +
                ", \nphoneNumber='" + phoneNumber + '\'' +
                ", \nemail='" + email + '\'' +
                ", \npassportNumber='" + passportNumber + '\'' +
                ", \ndriverLicenseNumber='" + driverLicenseNumber + '\'' +
                ", \nstatus='" + status + '\'' +
                ", \npasswordSha256='" + passwordSha256 + '\'' +
                '}';
    }
}
