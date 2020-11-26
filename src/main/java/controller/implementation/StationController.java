package controller.implementation;

import model.implementation.Station;
import service.implementation.GeneralService;
import service.implementation.StationService;

public class StationController extends GeneralController<Station> {
    private static final StationService STATION_SERVICE = new StationService();

    @Override
    public final GeneralService<Station> getService() {
        return STATION_SERVICE;
    }
}
