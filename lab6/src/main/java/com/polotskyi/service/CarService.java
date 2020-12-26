package com.polotskyi.service;

import com.polotskyi.domain.imp.Car;
import com.polotskyi.repository.CarRepository;
import com.polotskyi.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarService {
    @Autowired
    CarRepository carRepository;
    StationRepository stationRepository;

    public List<Car> getAll() {
        return carRepository.findAll();
    }

    public Car getCar(Integer id) {
        if(carRepository.existsById(id)) {
            Car car = carRepository.findById(id).get();
            return car;
        } else {
            return null;
        }
    }

    @Transactional
    public Car createCar(Car car) {
        return carRepository.save(car);
    }

    @Transactional
    public Car updateCar(Car uCar, Integer id) {
        if(carRepository.existsById(id)) {
            Car car = carRepository.findById(id).get();
            car.setBrand(uCar.getBrand() != null ? uCar.getBrand() : car.getBrand());
            car.setModel(uCar.getModel() != null ? uCar.getModel() : car.getModel());
            car.setPlateNumber(uCar.getPlateNumber() != null ? uCar.getPlateNumber() : car.getPlateNumber());
            car.setStationById(uCar.getStationById() != null && stationRepository.existsById(uCar.getStationById().getId()) ? uCar.getStationById() : car.getStationById());
            car.setStatus(uCar.getStatus() != null ? uCar.getStatus() : car.getStatus());
            car.setVinNumber(uCar.getVinNumber() != null ? uCar.getVinNumber() : car.getVinNumber());
            car.setYear(uCar.getYear() != null ? uCar.getYear() : car.getYear());

            return car;
        } else {
            return  null;
        }
    }

    @Transactional
    public boolean deleteCar(Integer id) {
        if(carRepository.existsById(id)) {
            carRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
