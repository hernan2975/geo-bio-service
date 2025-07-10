
package com.portfolio.geobioservice.service;

import com.portfolio.geobioservice.client.NominatimClient;
import com.portfolio.geobioservice.model.AddressResponse;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GeolocationServiceTest {

    @Test
    void testGetAddress_UsesClient() {
        NominatimClient mockClient = Mockito.mock(NominatimClient.class);
        Mockito.when(mockClient.fetchAddress(-37.0, -64.0))
                .thenReturn(new AddressResponse("Calle Falsa 123"));

        GeolocationService service = new GeolocationService(mockClient);
        AddressResponse response = service.getAddress(-37.0, -64.0);

        assertEquals("Calle Falsa 123", response.address());
    }
}
