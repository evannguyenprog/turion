package org.turion.mcs;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;
import org.turion.mcs.model.Image;
import org.turion.mcs.model.ImageRequest;
import org.turion.mcs.model.StatusEnum;
import org.turion.mcs.repository.ImageRepository;
import org.turion.mcs.repository.ImageRequestRepository;
import org.turion.mcs.service.McsService;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class McsServiceTest {

    @Mock
    private ImageRequestRepository imageRequestRepository;

    @Mock
    private ImageRepository imageRepository;

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private McsService mcsService;

    @Test
    void communicateWithSatellite() {
        // Mock data
        List<ImageRequest> imageRequests = Collections.singletonList(new ImageRequest());

        // Mock repository behavior
        when(imageRequestRepository.findAllByStatus(StatusEnum.CREATED)).thenReturn(imageRequests);

        // Mock restTemplate behavior
        ResponseEntity<Void> voidResponseEntity = ResponseEntity.noContent().build();
        when(restTemplate.postForEntity(anyString(), any(), eq(Void.class))).thenReturn(voidResponseEntity);
        when(restTemplate.exchange(anyString(), eq(HttpMethod.GET), any(), eq(new ParameterizedTypeReference<List<Image>>() {})))
                .thenReturn(ResponseEntity.ok(Collections.emptyList()));

        // Call the method
        mcsService.communicateWithSatellite();

        // Verify that repository methods and restTemplate methods were called
        verify(imageRequestRepository).findAllByStatus(StatusEnum.CREATED);
        verify(restTemplate, times(imageRequests.size())).postForEntity(anyString(), any(), eq(Void.class));
        verify(restTemplate, times(imageRequests.size())).exchange(anyString(), eq(HttpMethod.GET), any(), eq(new ParameterizedTypeReference<List<Image>>() {}));
        verify(imageRequestRepository, times(imageRequests.size())).save(any(ImageRequest.class));
        verify(imageRepository).saveAll(anyList());
    }

    // Add more test methods for other functions in McsService
}
