package org.turion.clientapi;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.turion.clientapi.model.Image;
import org.turion.clientapi.repository.ImageRepository;
import org.turion.clientapi.service.ImageService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class ImageServiceTest {

    @Mock
    private ImageRepository imageRepository;

    @Mock
    private Logger log;

    @InjectMocks
    private ImageService imageService;

    @Test
    void getImagesBySatellite() {
        // Mock data
        Long satelliteId = 1L;
        List<Image> mockImages = List.of(/* create mock Image objects as needed */);

        // Mock repository behavior
        when(imageRepository.findAllImagesById(satelliteId)).thenReturn(mockImages);

        // Call the service method
        List<Image> result = imageService.getImagesBySatellite(satelliteId);

        // Verify that the repository method is called with the correct arguments
        verify(imageRepository).findAllImagesById(satelliteId);

        // Add assertions based on your expected behavior
        // For example, assert that the result is the same as the mockImages
        assertEquals(mockImages, result);
    }

}
