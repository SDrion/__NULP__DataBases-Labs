package com.polotskyi.controller.imp;

import com.polotskyi.domain.imp.Car;
import com.polotskyi.service.IGeneralService;
import com.polotskyi.service.imp.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("car")
public class CarController extends GeneralController<Car> {

    @Autowired
    CarService carService;

    @Override
    public final IGeneralService<Car> getService() {
        return carService;
    }
}
