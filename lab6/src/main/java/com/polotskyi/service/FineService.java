package com.polotskyi.service;

import com.polotskyi.domain.imp.Fine;
import com.polotskyi.repository.FineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FineService {
    @Autowired
    FineRepository fineRepository;

    public List<Fine> getAll() {
        return fineRepository.findAll();
    }

    public Fine getFine(Integer id) {
        if(fineRepository.existsById(id)) {
            Fine fine = fineRepository.findById(id).get();
            return fine;
        } else {
            return null;
        }
    }

    @Transactional
    public Fine createFine(Fine fine) {
        return fineRepository.save(fine);
    }

    @Transactional
    public Fine updateFine(Fine uFine, Integer id) {
        if(fineRepository.existsById(id)) {
            Fine fine = fineRepository.findById(id).get();
            fine.setPaymentDue(uFine.getPaymentDue());
            fine.setStatus(uFine.getStatus());
            fine.setUserByUserId(uFine.getUserByUserId());

            return fine;
        } else {
            return  null;
        }
    }

    @Transactional
    public boolean deleteFine(Integer id) {
        if(fineRepository.existsById(id)) {
            fineRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
