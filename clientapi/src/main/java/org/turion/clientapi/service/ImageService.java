package org.turion.clientapi.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.turion.clientapi.model.Image;
import org.turion.clientapi.repository.ImageRepository;
import org.turion.clientapi.service.ImageService;


import java.util.List;

@Service
public class ImageService {
    @Autowired
    private ImageRepository imageRepository;

    private static final Logger log = LoggerFactory.getLogger(SatelliteService.class);

    public List<Image> getImagesBySatellite(Long id) {
        List<Image> images = imageRepository.findAllImagesById(id);
        if(images.isEmpty()){
            log.info("No Images Exist for Satellite with id: {}", id);
        }
        return images;
    }
}
