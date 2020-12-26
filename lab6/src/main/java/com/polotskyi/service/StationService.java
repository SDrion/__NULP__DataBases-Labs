package com.polotskyi.service;

import com.polotskyi.domain.imp.Station;
import com.polotskyi.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StationService {
    @Autowired
    StationRepository stationRepository;

    public List<Station> getAll() {
        return stationRepository.findAll();
    }

    public Station getStation(Integer id) {
        if(stationRepository.existsById(id)) {
            Station station = stationRepository.findById(id).get();
            return station;
        } else {
            return null;
        }
    }

    @Transactional
    public Station createStation(Station station) {
        return stationRepository.save(station);
    }

    @Transactional
    public Station updateStation(Station uStation, Integer id) {
        if(stationRepository.existsById(id)) {
            Station station = stationRepository.findById(id).get();
            station.setAddress(uStation.getAddress());
            station.setCity(uStation.getCity());
            station.setName(uStation.getName());

            return station;
        } else {
            return  null;
        }
    }

    @Transactional
    public boolean deleteStation(Integer id) {
        if(stationRepository.existsById(id)) {
            stationRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
