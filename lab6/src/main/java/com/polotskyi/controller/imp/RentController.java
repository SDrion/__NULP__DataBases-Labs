package com.polotskyi.controller.imp;

import com.polotskyi.domain.imp.Rent;
import com.polotskyi.service.IGeneralService;
import com.polotskyi.service.imp.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rent")
public class RentController extends GeneralController<Rent> {

    @Autowired
    RentService rentService;

    @Override
    public final IGeneralService<Rent> getService() {
        return rentService;
    }
}
