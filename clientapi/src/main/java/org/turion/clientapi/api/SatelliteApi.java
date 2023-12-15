package org.turion.clientapi.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.turion.clientapi.model.Satellite;
import org.turion.clientapi.service.SatelliteService;

import java.util.List;

@RestController
@RequestMapping("/satellites")
public class SatelliteApi {
    @Autowired
    SatelliteService satelliteService;

    /**
     *  Create satellite to be tracked
     *  Body contains name of satellite
     * @param satellite
     */
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Satellite createSatellite(@RequestBody Satellite satellite) {
        System.out.println("Received Satellite: " + satellite.toString());
        return satelliteService.createSatellite(satellite);
    }


}
