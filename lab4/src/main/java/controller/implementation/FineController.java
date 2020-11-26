package controller.implementation;

import model.implementation.Fine;
import service.implementation.FineService;
import service.implementation.GeneralService;

public class FineController extends GeneralController<Fine> {
    private static final FineService FINE_SERVICE = new FineService();

    @Override
    public final GeneralService<Fine> getService() {
        return FINE_SERVICE;
    }
}
