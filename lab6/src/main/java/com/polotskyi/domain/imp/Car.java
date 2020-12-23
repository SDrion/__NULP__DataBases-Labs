package com.polotskyi.domain.imp;

import com.polotskyi.domain.IGeneralModel;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="car", schema="polotskyi_lab3")
public class Car implements IGeneralModel {
    private Integer id;
    private String brand;
    private String model;
    private Integer year;
    private String plateNumber;
    private String vinNumber;
    private String status;
    private Station stationById;

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
    @Column(name = "brand")
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Basic
    @Column(name = "model")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Basic
    @Column(name = "year")
    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Basic
    @Column(name = "plate_number")
    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    @Basic
    @Column(name = "vin_number")
    public String getVinNumber() {
        return vinNumber;
    }

    public void setVinNumber(String vinNumber) {
        this.vinNumber = vinNumber;
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
    @JoinColumn(name = "station_id", referencedColumnName = "id", nullable = false)
    public Station getStationById() {
        return stationById;
    }

    public void setStationById(Station stationById) {
        this.stationById = stationById;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(id, car.id) &&
                Objects.equals(brand, car.brand) &&
                Objects.equals(model, car.model) &&
                Objects.equals(year, car.year) &&
                Objects.equals(plateNumber, car.plateNumber) &&
                Objects.equals(vinNumber, car.vinNumber) &&
                Objects.equals(status, car.status) &&
                Objects.equals(stationById, car.stationById);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brand, model, year, plateNumber, vinNumber, status, stationById);
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", plateNumber='" + plateNumber + '\'' +
                ", vin_number='" + vinNumber + '\'' +
                ", status='" + status + '\'' +
                ", stationId=" + stationById +
                '}';
    }
}
