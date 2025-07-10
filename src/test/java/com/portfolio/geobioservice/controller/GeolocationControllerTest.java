
package com.portfolio.geobioservice.controller;

import com.portfolio.geobioservice.model.CoordinateRequest;
import com.portfolio.geobioservice.model.AddressResponse;
import com.portfolio.geobioservice.service.GeolocationService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GeolocationControllerTest {

    @Test
    void testGeolocate_ReturnsAddress() {
        GeolocationService mockService = Mockito.mock(GeolocationService.class);
        CoordinateRequest request = new CoordinateRequest(-37.0, -64.0);
        Mockito.when(mockService.getAddress(-37.0, -64.0))
                .thenReturn(new AddressResponse("Av. Principal 123"));

        GeolocationController controller = new GeolocationController(mockService);
        ResponseEntity<AddressResponse> response = controller.geolocate(request);

        assertEquals("Av. Principal 123", response.getBody().address());
    }
}
