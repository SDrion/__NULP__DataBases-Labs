package com.polotskyi.controller.imp;

import com.polotskyi.domain.imp.Fine;
import com.polotskyi.service.IGeneralService;
import com.polotskyi.service.imp.FineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("fine")
public class FineController extends GeneralController<Fine> {

    @Autowired
    FineService fineService;

    @Override
    public final IGeneralService<Fine> getService() {
        return fineService;
    }
}
