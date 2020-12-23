package com.polotskyi.controller.imp;

import com.polotskyi.domain.imp.Station;
import com.polotskyi.service.IGeneralService;
import com.polotskyi.service.imp.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("station")
public class StationController extends GeneralController<Station> {

    @Autowired
    StationService stationService;

    @Override
    public final IGeneralService<Station> getService() {
        return stationService;
    }
}
