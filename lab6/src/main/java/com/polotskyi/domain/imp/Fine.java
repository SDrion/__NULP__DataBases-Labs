package com.polotskyi.domain.imp;

import com.polotskyi.domain.IGeneralModel;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="fine", schema="polotskyi_lab3")
public class Fine implements IGeneralModel {
    private Integer id;
    private Float paymentDue;
    private String status;
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
    @Column(name = "payment_due")
    public Float getPaymentDue() {
        return paymentDue;
    }

    public void setPaymentDue(Float paymentDue) {
        this.paymentDue = paymentDue;
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
        Fine fine = (Fine) o;
        return Objects.equals(id, fine.id) &&
                Objects.equals(paymentDue, fine.paymentDue) &&
                Objects.equals(status, fine.status) &&
                Objects.equals(userByUserId, fine.userByUserId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, paymentDue, status, userByUserId);
    }

    @Override
    public String toString() {
        return "Fine{" +
                "id=" + id +
                ", paymentDue=" + paymentDue +
                ", status='" + status + '\'' +
                ", userByUserId=" + userByUserId +
                '}';
    }
}
