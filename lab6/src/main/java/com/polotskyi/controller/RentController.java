package com.polotskyi.controller;

import com.polotskyi.domain.imp.Rent;
import com.polotskyi.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping(value = "rent")
public class RentController {
    @Autowired
    private RentService rentService;

    @GetMapping(value = "/")
    public List<Rent> getRents() {
        return rentService.getAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Rent> getRent(
            @PathVariable("id") Integer id
    ) {
        Rent rent;
        ResponseEntity<Rent> status = (rent = rentService.getRent(id)) == null
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(rent, HttpStatus.OK);
        return status;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Rent> createRent(@RequestBody Rent rent) {
        ResponseEntity<Rent> status = rent.getId() == null ?
                new ResponseEntity<>(HttpStatus.BAD_REQUEST) :
                (rentService.getRent(rent.getId())) == null
                        ? new ResponseEntity<>(rentService.createRent(rent), HttpStatus.CREATED)
                        : new ResponseEntity<>(HttpStatus.CONFLICT);
        return status;
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Rent> deleteRent(@PathVariable("id") Integer id) {
        HttpStatus status = rentService.deleteRent(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return ResponseEntity.status(status).build();
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Rent> updateRent(
            @PathVariable("id") Integer id,
            @RequestBody Rent rent
    ) {
        Rent updateRent = rentService.updateRent(rent, id);
        ResponseEntity<Rent> status = updateRent == null
                ? new ResponseEntity<Rent>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<Rent>(HttpStatus.OK);
        return status;
    }
}
