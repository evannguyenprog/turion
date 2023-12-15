package org.turion.clientapi.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.turion.clientapi.model.Image;
import org.turion.clientapi.service.ImageService;

import java.util.List;

@RestController
@RequestMapping("/get-images")
public class ImageApi {
    @Autowired
    ImageService imageService;

    /**
     * Get images of the tracked client satellite that were taken by our satellite.
     * Get all images
     * @param id
     * @return list of images
     */
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Image> getImagesBySatellite(@PathVariable Long id){
        return imageService.getImagesBySatellite(id);
    }

}
