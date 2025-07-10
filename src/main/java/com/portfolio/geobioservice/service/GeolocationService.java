
package com.portfolio.geobioservice.service;

import com.portfolio.geobioservice.client.NominatimClient;
import com.portfolio.geobioservice.model.AddressResponse;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class GeolocationService {

    private final NominatimClient nominatimClient;

    public GeolocationService(NominatimClient nominatimClient) {
        this.nominatimClient = nominatimClient;
    }

    @Cacheable("coordinates")
    public AddressResponse getAddress(double lat, double lon) {
        return nominatimClient.fetchAddress(lat, lon);
    }
}
