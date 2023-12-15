package org.turion.clientapi;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.springframework.boot.test.context.SpringBootTest;
import org.turion.clientapi.model.Satellite;
import org.turion.clientapi.repository.SatelliteRepository;
import org.turion.clientapi.service.SatelliteService;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class SatelliteServiceTest {

    @Mock
    private SatelliteRepository satelliteRepository;

    @Mock
    private Logger log;

    @InjectMocks
    private SatelliteService satelliteService;

    @Test
    void createSatellite() {
        // Given
        Satellite inputSatellite = new Satellite(); // Create input satellite object for testing

        // Mock the behavior of the repository save method
        when(satelliteRepository.save(inputSatellite)).thenReturn(inputSatellite);

        // When
        Satellite createdSatellite = satelliteService.createSatellite(inputSatellite);

        // Then
        // Verify that the repository's save method was called with the input satellite
        verify(satelliteRepository).save(inputSatellite);

    }
}
