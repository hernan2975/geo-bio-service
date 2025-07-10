
package com.portfolio.geobioservice.controller;

import com.portfolio.geobioservice.model.AddressResponse;
import com.portfolio.geobioservice.model.CoordinateRequest;
import com.portfolio.geobioservice.service.GeolocationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/geolocate")
public class GeolocationController {

    private final GeolocationService geolocationService;

    public GeolocationController(GeolocationService geolocationService) {
        this.geolocationService = geolocationService;
    }

    @PostMapping
    public ResponseEntity<AddressResponse> geolocate(@RequestBody @Valid CoordinateRequest request) {
        AddressResponse response = geolocationService.getAddress(request.latitude(), request.longitude());
        return ResponseEntity.ok(response);
    }
}
