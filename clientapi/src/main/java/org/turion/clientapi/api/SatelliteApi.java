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

//    /**
//     * Get images of the tracked client satellite that were taken by our satellite.
//     * GET ALL IMAGES, Returns a LIST
//     * @param id
//     * @return
//     */
//    @GetMapping("/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public List<String> getImagesBySatellite(@PathVariable Long id){
//        return satelliteService.getImagesBySatellite(id);
//    }

    /**
     *
     * @param satellite
     */
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Satellite createSatellite(@RequestBody Satellite satellite) {
        System.out.println("Received Satellite: " + satellite.toString());
        return satelliteService.createSatellite(satellite);
    }


}
