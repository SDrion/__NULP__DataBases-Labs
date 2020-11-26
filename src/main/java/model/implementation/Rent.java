package model.implementation;

import model.IGeneralModel;

public class Rent implements IGeneralModel {
    private Integer id;
    private Float price;
    private String status;
    private Integer car_id;
    private Integer user_id;

    public Rent(Integer id, Float price, String status, Integer car_id, Integer user_id) {
        this.id = id;
        this.price = price;
        this.status = status;
        this.car_id = car_id;
        this.user_id = user_id;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCar_id() {
        return car_id;
    }

    public void setCar_id(Integer car_id) {
        this.car_id = car_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Rent{" +
                "id=" + id +
                ", price=" + price +
                ", status='" + status + '\'' +
                ", car_id=" + car_id +
                ", user_id=" + user_id +
                '}';
    }
}
