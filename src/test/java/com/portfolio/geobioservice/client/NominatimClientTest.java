
package com.portfolio.geobioservice.client;

import com.portfolio.geobioservice.model.AddressResponse;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class NominatimClientTest {

    @Test
    void testFetchAddress_SimulatedCall() {
        NominatimClient client = new NominatimClient(); // Puede simularse con WebTestClient
        AddressResponse response = client.fetchAddress(-37.0, -64.0);

        assertNotNull(response);
    }
}
