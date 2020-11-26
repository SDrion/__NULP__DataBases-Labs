package service.implementation;

import DAO.IGeneralDAO;
import DAO.implementation.RentDAO;
import model.implementation.Rent;

public class RentService extends GeneralService<Rent> {
    private final IGeneralDAO<Rent, Integer> rentDAOImplementation = new RentDAO();

    @Override
    public final IGeneralDAO<Rent, Integer> getDAO() {
        return rentDAOImplementation;
    }
}
