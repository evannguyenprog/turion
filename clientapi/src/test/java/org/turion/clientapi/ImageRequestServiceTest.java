package org.turion.clientapi;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.turion.clientapi.model.ImageRequest;
import org.turion.clientapi.model.StatusEnum;
import org.turion.clientapi.repository.ImageRequestRepository;
import org.turion.clientapi.service.ImageRequestService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class ImageRequestServiceTest {

    @Mock
    private ImageRequestRepository imageRequestRepository;

    @Mock
    private Logger log;

    @InjectMocks
    private ImageRequestService imageRequestService;

    @Test
    void findAllImageRequestsBySatelliteId() {
        // Given
        Long satelliteId = 1L;
        List<String> expectedImageRequests = new ArrayList<>(); // Add expected image requests here to flesh out testing

        // Mock the behavior of the repository method
        when(imageRequestRepository.findAllImageRequestsBySatelliteId(satelliteId)).thenReturn(expectedImageRequests);

        // When
        List<String> actualImageRequests = imageRequestService.findAllImageRequestsBySatelliteId(satelliteId);

        // Then
        assertEquals(expectedImageRequests, actualImageRequests);
        verify(imageRequestRepository).findAllImageRequestsBySatelliteId(satelliteId);
    }

    // Add more test methods for other functions in ImageRequestService
}
