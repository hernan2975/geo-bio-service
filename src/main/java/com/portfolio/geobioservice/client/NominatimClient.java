
package com.portfolio.geobioservice.client;

import com.portfolio.geobioservice.exception.ExternalApiException;
import com.portfolio.geobioservice.model.AddressResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class NominatimClient {

    private final WebClient webClient = WebClient.builder()
            .baseUrl("https://nominatim.openstreetmap.org")
            .defaultHeader("User-Agent", "GeoBioService")
            .build();

    public AddressResponse fetchAddress(double lat, double lon) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/reverse")
                        .queryParam("format", "json")
                        .queryParam("lat", lat)
                        .queryParam("lon", lon)
                        .build())
                .retrieve()
                .bodyToMono(AddressResponse.class)
                .onErrorMap(e -> new ExternalApiException("Error al consultar Nominatim"))
                .block();
    }
}
