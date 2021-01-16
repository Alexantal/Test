package com.space.controller;

import com.space.model.Ship;
import com.space.service.ShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShipController {
    private final ShipService shipService;
    @Autowired
    public ShipController(ShipService shipService) {
        this.shipService = shipService;
    }

    @GetMapping(value = "/rest/ships")
    public ResponseEntity<List<Ship>> getAllShips() {
        List<Ship> ships = this.shipService.getAll();

        return ships != null/* && !ships.isEmpty()*/
               ? new ResponseEntity<>(ships, HttpStatus.OK)
               : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
