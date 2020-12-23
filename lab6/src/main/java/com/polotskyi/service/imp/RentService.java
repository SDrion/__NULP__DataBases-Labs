package com.polotskyi.service.imp;

import com.polotskyi.domain.imp.Rent;
import com.polotskyi.repository.RentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class RentService extends GeneralService<Rent> {
    @Autowired
    RentRepository rentRepository;

    @Override
    public JpaRepository<Rent, Integer> getRepository() {
        return rentRepository;
    }
}
