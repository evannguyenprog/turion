package org.turion.clientapi.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.turion.clientapi.model.Satellite;
import org.turion.clientapi.repository.SatelliteRepository;

import java.util.List;


@Service
//@Slf4j
public class SatelliteService {
    @Autowired
    private SatelliteRepository satelliteRepository;

    private static final Logger log = LoggerFactory.getLogger(SatelliteService.class);

//    /**
//     * Write what the method is doing here
//     * @return list of Images for a specific client satellite
//     */
//    public List<String> getImagesBySatellite(Long id) {
//        List<String> images = satelliteRepository.findAllImagesById(id);
//        if(images.isEmpty()){
//            log.info("No Images Exist for Satellite with id: {}", id);
//        }
//        return images;
//    }

    public Satellite createSatellite(Satellite satellite) {
        Satellite createdSatellite = satelliteRepository.save(satellite);
        log.info("Satellite Created");
        return createdSatellite;
    }

}


