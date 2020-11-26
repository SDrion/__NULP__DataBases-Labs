package controller.implementation;

import model.implementation.Rent;
import service.implementation.GeneralService;
import service.implementation.RentService;

public class RentController extends GeneralController<Rent> {
    private static final RentService RENT_SERVICE = new RentService();

    @Override
    public final GeneralService<Rent> getService() {
        return RENT_SERVICE;
    }
}
