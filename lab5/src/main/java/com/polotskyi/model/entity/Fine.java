package com.polotskyi.model.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "fine")
public class Fine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "payment_due")
    private BigDecimal paymentDue;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User userByUserId;

    public Fine() {
    }

    public Fine(BigDecimal paymentDue, String status, User userByUserId) {
        this.paymentDue = paymentDue;
        this.status = status;
        this.userByUserId = userByUserId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getPaymentDue() {
        return paymentDue;
    }

    public void setPaymentDue(BigDecimal paymentDue) {
        this.paymentDue = paymentDue;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }

    @Override
    public String toString() {
        return "\n\n{id=" + id +
                ", \npaymentDue=" + paymentDue + '\'' +
                ", \nstatus='" + status + '\'' +
                ", \nuserByUserId=" + userByUserId + '\'' +
                '}';
    }
}
