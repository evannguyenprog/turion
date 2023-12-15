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
//@Slf4j
public class ImageRequestService {
    @Autowired
    private ImageRequestRepository imageRequestRepository;


    private static final Logger log = LoggerFactory.getLogger(ImageRequestService.class);

    /**
     * Write what the method is doing here
     * @return list of Images for a specific client satellite
     */
    public List<String> findAllImageRequestsBySatelliteId(Long satelliteId) {
        List<String> imageRequests = imageRequestRepository.findAllImageRequestsBySatelliteId(satelliteId);
        if(imageRequests.isEmpty()){
            log.info("No Images Requests Exist for Satellite with id: {}", satelliteId);
        }
        return imageRequests;
    }


    public void createImageRequest(ImageRequest imageRequest) {
        imageRequest.setStatus(StatusEnum.CREATED);
        imageRequestRepository.save(imageRequest);
        log.info("Request Created");
    }
}
