package com.polotskyi.controller;

import com.polotskyi.domain.imp.Car;
import com.polotskyi.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping(value = "car")
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping(value = "/")
    public List<Car> getCars() {
        return carService.getAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Car> getCar(
            @PathVariable("id") Integer id
    ) {
        Car car;
        ResponseEntity<Car> status = (car = carService.getCar(id)) == null
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(car, HttpStatus.OK);
        return status;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Car> createCar(@RequestBody Car car) {
        return new ResponseEntity<>(carService.createCar(car), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Car> deleteCar(@PathVariable("id") Integer id) {
        HttpStatus status = carService.deleteCar(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return ResponseEntity.status(status).build();
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Car> updateCar(
            @PathVariable("id") Integer id,
            @RequestBody Car car
    ) {
        Car updateCar = carService.updateCar(car, id);
        ResponseEntity<Car> status = updateCar == null
                ? new ResponseEntity<Car>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<Car>(HttpStatus.OK);
        return status;
    }
}
