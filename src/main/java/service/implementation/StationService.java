package service.implementation;

import DAO.IGeneralDAO;
import DAO.implementation.StationDAO;
import model.implementation.Station;

public class StationService extends GeneralService<Station> {
    private final IGeneralDAO<Station, Integer> stationDAOImplementation = new StationDAO();

    @Override
    public final IGeneralDAO<Station, Integer> getDAO() {
        return stationDAOImplementation;
    }
}
