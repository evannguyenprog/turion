package org.turion.mcs.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.turion.mcs.model.Image;
import org.turion.mcs.model.ImageRequest;
import org.turion.mcs.model.StatusEnum;
import org.turion.mcs.repository.ImageRepository;
import org.turion.mcs.repository.ImageRequestRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class McsService {

    //logger declaration for log statements
    private static final Logger log = LoggerFactory.getLogger(McsService.class);

    @Autowired
    private ImageRequestRepository imageRequestRepository;

    @Autowired
    private ImageRepository imageRepository;


    @Autowired
    private RestTemplate restTemplate;

    // URL of the Satellite API
    private static final String SATELLITE_API_URL = "http://sat:8083/satellites";

    /**
     * Run on a fixed interval
     * Find all image requests with the status of CREATED
     * For the image requests with the CREATED status, send an API call to the satellite to initiate fulfilling the image requests
     * Then download all the images from the satellite
     */
    @Scheduled(fixedRate = 30000)  // Adjust the rate as needed, current @ every 30 seconds
    public void communicateWithSatellite() {
        log.info("Start communication with the satellite...");

        // 1. Get all pending imaging requests from the database
        List<ImageRequest> imageRequests = imageRequestRepository.findAllByStatus(StatusEnum.CREATED);
        log.info("Found {} pending imaging requests.", imageRequests.size());

        // 2. Send imaging requests to the satellite
        sendImagingRequestsToSatellite(imageRequests);

        // 3. Periodically download all images from the satellite
        downloadAllImagesFromSatellite(imageRequests);

        log.info("Communication with the satellite completed.");
    }

    /**
     * For all image requests, make an API call to satellite to initiate taking an image
     * Update the image request status to pending
     * @param requests
     */
    private void sendImagingRequestsToSatellite(List<ImageRequest> requests) {
        log.info("Sending imaging requests to the satellite...");

        for (ImageRequest request : requests) {
            // Make a POST request to the Satellite API
            restTemplate.postForEntity(SATELLITE_API_URL + "/" + request.getSatelliteId() + "/imaging-request?imageRequestId=" + request.getId(), request, Void.class);

            // Update the status of the request in the database
            request.setStatus(StatusEnum.PENDING);
            imageRequestRepository.save(request);
            log.info("Imaging request sent to satellite: {}", request);
        }

        log.info("Imaging requests sent to the satellite.");
    }

    /**
     * Make an API call to satellite to download all images from satellite local storage(cache)
     * For the returned images, get the associated image request, then update its status to DOWNLOADED
     */
    private void downloadAllImagesFromSatellite(List<ImageRequest> requests) {
        log.info("Downloading all images from the satellite...");
        List<Image> allDownloadedImages = new ArrayList<>();

        for (ImageRequest request : requests){
            // Make a GET request to the Satellite API to download all images
            ResponseEntity<List<Image>> responseEntity = restTemplate.exchange(
                    SATELLITE_API_URL + "/" + request.getSatelliteId() + "/download",
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<Image>>(){});

            List<Image> downloadedImages = responseEntity.getBody();

            // Update the status of the corresponding image requests in the database
            updateImageRequestStatus(downloadedImages, StatusEnum.DOWNLOADED);
            allDownloadedImages.addAll(downloadedImages);

        }

        log.info("All images downloaded from the satellite.");
        log.info("Saving images to image repository.");

        imageRepository.saveAll(allDownloadedImages);

        log.info("Images saved.");

    }

    /**
     * For each image, get its image request and update status
     * @param images
     * @param newStatus
     */
    private void updateImageRequestStatus(List<Image> images, StatusEnum newStatus) {
        log.info("Updating image request status...");

        for (Image image : images) {
            ImageRequest imageRequest = imageRequestRepository.findByImageRequestId(image.getImageRequestId());
            if (imageRequest != null) {
                imageRequest.setStatus(newStatus);
                imageRequestRepository.save(imageRequest);
                log.info("Image request status updated: {}", imageRequest);
            }
        }

        log.info("Image request status updated for all images.");
    }
}
