package org.turion.clientapi.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.turion.clientapi.model.Satellite;
import org.turion.clientapi.repository.SatelliteRepository;


@Service
public class SatelliteService {
    @Autowired
    private SatelliteRepository satelliteRepository;

    private static final Logger log = LoggerFactory.getLogger(SatelliteService.class);

    /**
     * Create satellite definition
     * Create a satellite object and save it to the repository
     * @param satellite
     * @return
     */
    public Satellite createSatellite(Satellite satellite) {
        Satellite createdSatellite = satelliteRepository.save(satellite);
        log.info("Satellite Created");
        return createdSatellite;
    }

}


