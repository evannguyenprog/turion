package org.turion.clientapi.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.turion.clientapi.model.ImageRequest;
import org.turion.clientapi.service.ImageRequestService;

import java.util.List;

@RestController
@RequestMapping("/image-request")
public class ImageRequestApi {
    @Autowired
    ImageRequestService imageRequestService;

    /** Get all image requests for given satellite id
     * @param satelliteId
     * @return list of imagerequests
     */
    @GetMapping("/{satelliteId}")
    @ResponseStatus(HttpStatus.OK)
    public List<String> getImageRequest(@PathVariable Long satelliteId){
        return imageRequestService.findAllImageRequestsBySatelliteId(satelliteId);
    }

    /**
     * Return all image requests
     * For Testing and Visualization purposes
     * @return list of image requests
     */
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<ImageRequest> getAllImageRequests(){
        return imageRequestService.findAllImageRequests();
    }


    /**
     * Create an image request
     * Body contains satellite id
     * @param imageRequest
     */
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ImageRequest createImageRequest(@RequestBody ImageRequest imageRequest) {
        return imageRequestService.createImageRequest(imageRequest);
    }


}
