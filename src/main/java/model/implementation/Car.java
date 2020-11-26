package model.implementation;

import model.IGeneralModel;

public class Car implements IGeneralModel {
    private Integer id;
    private String brand;
    private String model;
    private Integer year;
    private String plate_number;
    private String vin_number;
    private String status;
    private Integer station_id;

    public Car(Integer id, String brand, String model, Integer year, String plate_number, String vin_number, String status, Integer station_id) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.plate_number = plate_number;
        this.vin_number = vin_number;
        this.status = status;
        this.station_id = station_id;
    }

    @Override
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

    public String getPlate_number() {
        return plate_number;
    }

    public void setPlate_number(String plate_number) {
        this.plate_number = plate_number;
    }

    public String getVin_number() {
        return vin_number;
    }

    public void setVin_number(String vin_number) {
        this.vin_number = vin_number;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getStation_id() {
        return station_id;
    }

    public void setStation_id(Integer station_id) {
        this.station_id = station_id;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", plate_number='" + plate_number + '\'' +
                ", vin_number='" + vin_number + '\'' +
                ", status='" + status + '\'' +
                ", station_id=" + station_id +
                '}';
    }
}
