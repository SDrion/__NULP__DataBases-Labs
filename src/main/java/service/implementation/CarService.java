package service.implementation;

import DAO.IGeneralDAO;
import DAO.implementation.CarDAO;
import model.implementation.Car;

public class CarService extends GeneralService<Car>{
    private final IGeneralDAO<Car, Integer> carDAOImplementation = new CarDAO();

    @Override
    public final IGeneralDAO<Car, Integer> getDAO() {
        return carDAOImplementation;
    }
}
