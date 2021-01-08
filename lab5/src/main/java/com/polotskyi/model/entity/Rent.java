package com.polotskyi.model.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "rent")
public class Rent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "car_id", referencedColumnName = "id", nullable = false)
    private Car carByCarId;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User userByUserId;

    public Rent() {
    }

    public Rent(BigDecimal price, String status, Car carByCarId, User userByUserId) {
        this.price = price;
        this.status = status;
        this.carByCarId = carByCarId;
        this.userByUserId = userByUserId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Car getCarByCarId() {
        return carByCarId;
    }

    public void setCarByCarId(Car carByCarId) {
        this.carByCarId = carByCarId;
    }

    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }

    @Override
    public String toString() {
        return "\n\n{id=" + id + '\'' +
                ", \nprice=" + price + '\'' +
                ", \nstatus='" + status + '\'' +
                ", \ncarByCarId=" + carByCarId + '\'' +
                ", \nuserByUserId=" + userByUserId + '\'' +
                '}' + "\n\n<next rent>\n\n\n\n";
    }
}
