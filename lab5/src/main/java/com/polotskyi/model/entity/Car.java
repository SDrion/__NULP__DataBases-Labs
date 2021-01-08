package com.polotskyi.model.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "year")
    private Integer year;

    @Column(name = "plate_number")
    private String plateNumber;

    @Column(name = "vin_number")
    private String vinNumber;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "station_id", referencedColumnName = "id", nullable = false)
    private Station stationByStationId;

    @OneToMany(mappedBy = "carByCarId")
    private Collection<Rent> rentsById;

    public Car() {}

    public Car(String brand, String model, Integer year, String plateNumber, String vinNumber, String status, Station stationByStationId) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.plateNumber = plateNumber;
        this.vinNumber = vinNumber;
        this.status = status;
        this.stationByStationId = stationByStationId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getVinNumber() {
        return vinNumber;
    }

    public void setVinNumber(String vinNumber) {
        this.vinNumber = vinNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Station getStationByStationId() {
        return stationByStationId;
    }

    public void setStationByStationId(Station stationByStationId) {
        this.stationByStationId = stationByStationId;
    }

    public Collection<Rent> getRentsById() {
        return rentsById;
    }

    public void setRentsById(Collection<Rent> rentsById) {
        this.rentsById = rentsById;
    }

    @Override
    public String toString() {
        return "\n\n{ id=" + id +
                ", \nbrand='" + brand + '\'' +
                ", \nmodel='" + model + '\'' +
                ", \nyear=" + year + '\'' +
                ", \nplateNumber='" + plateNumber + '\'' +
                ", \nvinNumber='" + vinNumber + '\'' +
                ", \nstatus='" + status + '\'' +
                ", \nstationByStationId=" + stationByStationId + '\'' +
                '}';
    }
}
