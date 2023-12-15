package org.turion.clientapi.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.turion.clientapi.model.ImageRequest;
import org.turion.clientapi.model.StatusEnum;
import org.turion.clientapi.repository.ImageRequestRepository;

import java.util.List;

@Service
public class ImageRequestService {
    @Autowired
    private ImageRequestRepository imageRequestRepository;

    private static final Logger log = LoggerFactory.getLogger(ImageRequestService.class);

    /**
     * Find all imagerequests by satellite id
     * Passes satellite id to db query to return all imagerequests where satellite id = request
     * @return list of Images for a specific client satellite
     */
    public List<String> findAllImageRequestsBySatelliteId(Long satelliteId) {
        List<String> imageRequests = imageRequestRepository.findAllImageRequestsBySatelliteId(satelliteId);
        if(imageRequests.isEmpty()){
            log.info("No Images Requests Exist for Satellite with id: {}", satelliteId);
        }
        return imageRequests;
    }

    /**
     * Create an image request for given satellite
     * Sets status enum to CREATED
     * Saves to image request repo
     * @param imageRequest
     * @return imgRequest
     */
    public ImageRequest createImageRequest(ImageRequest imageRequest) {
        imageRequest.setStatus(StatusEnum.CREATED);
        ImageRequest imgRequest = imageRequestRepository.save(imageRequest);
        log.info("Request Created");
        return imgRequest;
    }

    /**
     * Find all image requests
     * Gets all image requests from image request table
     * For visualization / testing purposes
     * @return list of image requests
     */
    public List<ImageRequest> findAllImageRequests() {
        List<ImageRequest> allImgRequest = imageRequestRepository.findAllImageRequests();
        return allImgRequest;
    }
}
