package model.implementation;

import model.IGeneralModel;

public class User implements IGeneralModel {
    private Integer id;
    private String first_name;
    private String last_name;
    private String phone_number;
    private String email;
    private String passport_number;
    private String drivers_license_number;
    private String status;
    private String password;

    public User(Integer id, String first_name, String last_name, String phone_number, String email, String passport_number, String drivers_license_number, String status, String password) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone_number = phone_number;
        this.email = email;
        this.passport_number = passport_number;
        this.drivers_license_number = drivers_license_number;
        this.status = status;
        this.password = password;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassport_number() {
        return passport_number;
    }

    public void setPassport_number(String passport_number) {
        this.passport_number = passport_number;
    }

    public String getDrivers_license_number() {
        return drivers_license_number;
    }

    public void setDrivers_license_number(String drivers_license_number) {
        this.drivers_license_number = drivers_license_number;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", email='" + email + '\'' +
                ", passport_number='" + passport_number + '\'' +
                ", drivers_license_number='" + drivers_license_number + '\'' +
                ", status='" + status + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
