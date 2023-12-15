package org.turion.sat.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.turion.sat.model.Image;
import org.turion.sat.model.Satellite;
import org.turion.sat.service.SatelliteService;

import java.util.List;

@RestController
@RequestMapping("/satellites/{id}")
public class SatelliteApi {
    @Autowired
    SatelliteService satelliteService;

    /**
     * Get images of the tracked client satellite that were taken by our satellite.
     * GET ALL IMAGES, Returns a LIST
     * @param id
     * @return
     */
    @GetMapping("/download")
    @ResponseStatus(HttpStatus.OK)
    public List<Image> downloadImages(@PathVariable Long id){
        return satelliteService.getImagesBySatellite(id);
    }

    private static final Logger log = LoggerFactory.getLogger(SatelliteService.class);


    /**
     * Handles image requests
     * @param id
     * @return void
     */
    @PostMapping("/imaging-request")
    @ResponseStatus(HttpStatus.OK)
    public void handleImagingRequest(@PathVariable Long id, @RequestParam Long imageRequestId) {
        log.info("Received imaging request for satellite ID: {}, image request ID: {}", id, imageRequestId);
        satelliteService.handleImagingRequest(id, imageRequestId);
    }



}
