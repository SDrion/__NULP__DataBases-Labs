package model.implementation;

import model.IGeneralModel;

public class Fine implements IGeneralModel {
    private Integer id;
    private Float paymant_due;
    private String status;
    private Integer user_id;

    public Fine(Integer id, Float paymant_due, String status, Integer user_id) {
        this.id = id;
        this.paymant_due = paymant_due;
        this.status = status;
        this.user_id = user_id;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getPaymant_due() {
        return paymant_due;
    }

    public void setPaymant_due(Float paymant_due) {
        this.paymant_due = paymant_due;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Fine{" +
                "id=" + id +
                ", paymant_due=" + paymant_due +
                ", status='" + status + '\'' +
                ", user_id=" + user_id +
                '}';
    }
}
