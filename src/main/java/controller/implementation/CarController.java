package controller.implementation;

import model.implementation.Car;
import service.implementation.CarService;
import service.implementation.GeneralService;

public class CarController extends GeneralController<Car> {
    private static final CarService CAR_SERVICE = new CarService();

    @Override
    public final GeneralService<Car> getService() {
        return CAR_SERVICE;
    }
}
