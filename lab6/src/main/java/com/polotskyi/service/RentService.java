package com.polotskyi.service;

import com.polotskyi.domain.imp.Rent;
import com.polotskyi.repository.RentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RentService {
    @Autowired
    RentRepository rentRepository;

    public List<Rent> getAll() {
        return rentRepository.findAll();
    }

    public Rent getRent(Integer id) {
        if(rentRepository.existsById(id)) {
            Rent rent = rentRepository.findById(id).get();
            return rent;
        } else {
            return null;
        }
    }

    @Transactional
    public Rent createRent(Rent rent) {
        return rentRepository.save(rent);
    }

    @Transactional
    public Rent updateRent(Rent uRent, Integer id) {
        if(rentRepository.existsById(id)) {
            Rent rent = rentRepository.findById(id).get();
            rent.setCarByCarId(uRent.getCarByCarId());
            rent.setPrice(uRent.getPrice());
            rent.setStatus(uRent.getStatus());
            rent.setUserByUserId(uRent.getUserByUserId());

            return rent;
        } else {
            return  null;
        }
    }

    @Transactional
    public boolean deleteRent(Integer id) {
        if(rentRepository.existsById(id)) {
            rentRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
