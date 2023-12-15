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


    //Get images of the tracked client satellite that were taken by our satellite.
    //GET ALL IMAGES, LIST

    /**
     *
     * @param satelliteId
     * @return
     */
    @GetMapping("/{satelliteId}")
    @ResponseStatus(HttpStatus.OK)
    public List<String> getImageRequest(@PathVariable Long satelliteId){
        return imageRequestService.findAllImageRequestsBySatelliteId(satelliteId);
    }


    /**
     *
     * @param imageRequest
     */
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createImageRequest(@RequestBody ImageRequest imageRequest) {
        imageRequestService.createImageRequest(imageRequest);
    }


}
