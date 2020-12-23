package com.polotskyi.service.imp;

import com.polotskyi.domain.imp.Fine;
import com.polotskyi.repository.FineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class FineService extends GeneralService<Fine> {
    @Autowired
    FineRepository fineRepository;

    @Override
    public JpaRepository<Fine, Integer> getRepository() {
        return fineRepository;
    }
}
