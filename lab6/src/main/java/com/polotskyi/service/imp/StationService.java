package com.polotskyi.service.imp;

import com.polotskyi.domain.imp.Station;
import com.polotskyi.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class StationService extends GeneralService<Station> {
    @Autowired
    StationRepository stationRepository;

    @Override
    public JpaRepository<Station, Integer> getRepository() {
        return stationRepository;
    }
}