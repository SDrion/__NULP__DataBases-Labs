package com.polotskyi.controller;

import com.polotskyi.domain.imp.Station;
import com.polotskyi.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping(value = "station")
public class StationController {
    @Autowired
    private StationService stationService;

    @GetMapping(value = "/")
    public List<Station> getStations() {
        return stationService.getAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Station> getStation(
            @PathVariable("id") Integer id
    ) {
        Station station;
        ResponseEntity<Station> status = (station = stationService.getStation(id)) == null
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(station, HttpStatus.OK);
        return status;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Station> createStation(@RequestBody Station station) {
        ResponseEntity<Station> status = station.getId() == null ?
                new ResponseEntity<>(HttpStatus.BAD_REQUEST) :
                (stationService.getStation(station.getId())) == null
                        ? new ResponseEntity<>(stationService.createStation(station), HttpStatus.CREATED)
                        : new ResponseEntity<>(HttpStatus.CONFLICT);
        return status;
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Station> deleteStation(@PathVariable("id") Integer id) {
        HttpStatus status = stationService.deleteStation(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return ResponseEntity.status(status).build();
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Station> updateStation(
            @PathVariable("id") Integer id,
            @RequestBody Station station
    ) {
        Station updateStation = stationService.updateStation(station, id);
        ResponseEntity<Station> status = updateStation == null
                ? new ResponseEntity<Station>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<Station>(HttpStatus.OK);
        return status;
    }
}
