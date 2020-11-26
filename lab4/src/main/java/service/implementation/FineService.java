package service.implementation;

import DAO.IGeneralDAO;
import DAO.implementation.FineDAO;
import model.implementation.Fine;

public class FineService extends GeneralService<Fine> {
    private final IGeneralDAO<Fine, Integer> fineDAOImplementation = new FineDAO();

    @Override
    public final IGeneralDAO<Fine, Integer> getDAO() {
        return fineDAOImplementation;
    }
}
