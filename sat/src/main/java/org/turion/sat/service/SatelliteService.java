package org.turion.sat.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.turion.sat.model.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class SatelliteService {

    // Cache images
    private final Map<Long, List<Image>> imageCache = new ConcurrentHashMap<>();

    private static final Logger log = LoggerFactory.getLogger(SatelliteService.class);

    /**
     * Get all images by the satellite id from the cache
     * @return list of Images for a specific client satellite
     */
    public List<Image> getImagesBySatellite(Long id) {
        List<Image> images = imageCache.getOrDefault(id, List.of());
        if (images.isEmpty()) {
            log.info("No Images Exist for Satellite with id: {}", id);
        }
        return images;
    }

    /**
     * Handle the image requests
     * Build an image object from the request values
     * Add it to the cache and log the image path
     * @param id
     * @param imageRequestId
     */
    public void handleImagingRequest(Long id, Long imageRequestId) {
        // Simulate the process of taking an image
        String imagePath = captureImage();
        Image image = Image.builder().imagePath(imagePath).imageRequestId(imageRequestId).satelliteId(id).build();
        imageCache.computeIfAbsent(id, k -> new ArrayList<>()).add(image);
        log.info("Image captured successfully. Image path: " + imagePath);
    }

    /**
     * Function to simulate returning the path to an image
     * Primary location for refinement / improvements
     * @return
     */
    private String captureImage() {
        // Simulate capturing an image and returning the image path
        return "path/to/captured/image.jpg";
    }

}


