package com.polotskyi.domain.imp;

import com.polotskyi.domain.IGeneralModel;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="rent", schema="polotskyi_lab3")
public class Rent implements IGeneralModel {
    private Integer id;
    private Float price;
    private String status;
    private Car carByCarId;
    private User userByUserId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "price")
    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @ManyToOne
    @JoinColumn(name = "car_id", referencedColumnName = "id", nullable = false)
    public Car getCarByCarId() {
        return carByCarId;
    }

    public void setCarByCarId(Car carByCarId) {
        this.carByCarId = carByCarId;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rent rent = (Rent) o;
        return Objects.equals(id, rent.id) &&
                Objects.equals(price, rent.price) &&
                Objects.equals(status, rent.status) &&
                Objects.equals(carByCarId, rent.carByCarId) &&
                Objects.equals(userByUserId, rent.userByUserId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, status, carByCarId, userByUserId);
    }

    @Override
    public String toString() {
        return "Rent{" +
                "id=" + id +
                ", price=" + price +
                ", status='" + status + '\'' +
                ", carByCarId=" + carByCarId +
                ", userByUserId=" + userByUserId +
                '}';
    }
}
