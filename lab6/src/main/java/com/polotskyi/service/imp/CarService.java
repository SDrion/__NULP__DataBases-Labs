package com.polotskyi.service.imp;

import com.polotskyi.domain.imp.Car;
import com.polotskyi.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class CarService extends GeneralService<Car> {
    @Autowired
    CarRepository carRepository;

    @Override
    public JpaRepository<Car, Integer> getRepository() {
        return carRepository;
    }
}
