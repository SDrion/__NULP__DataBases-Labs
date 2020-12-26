package com.polotskyi.controller;

import com.polotskyi.domain.imp.Fine;
import com.polotskyi.service.FineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping(value = "fine")
public class FineController {
    @Autowired
    private FineService fineService;

    @GetMapping(value = "/")
    public List<Fine> getFines() {
        return fineService.getAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Fine> getFine(
            @PathVariable("id") Integer id
    ) {
        Fine fine;
        ResponseEntity<Fine> status = (fine = fineService.getFine(id)) == null
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(fine, HttpStatus.OK);
        return status;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Fine> createFine(@RequestBody Fine fine) {
        ResponseEntity<Fine> status = fine.getId() == null ?
                new ResponseEntity<>(HttpStatus.BAD_REQUEST) :
                (fineService.getFine(fine.getId())) == null
                ? new ResponseEntity<>(fineService.createFine(fine), HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.CONFLICT);
        return status;
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Fine> deleteFine(@PathVariable("id") Integer id) {
        HttpStatus status = fineService.deleteFine(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return ResponseEntity.status(status).build();
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Fine> updateFine(
            @PathVariable("id") Integer id,
            @RequestBody Fine fine
            ) {
        Fine updateFine = fineService.updateFine(fine, id);
        ResponseEntity<Fine> status = updateFine == null
                ? new ResponseEntity<Fine>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<Fine>(HttpStatus.OK);
        return status;
    }
}
