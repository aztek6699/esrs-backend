package com.zain.locationservice.controller;

import com.zain.locationservice.model.GenericResponse;
import com.zain.locationservice.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/location")
public class LocationController {

    private final LocationService service;

    @Autowired
    public LocationController(LocationService service) {
        this.service = service;
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<GenericResponse> getLocationByName(@PathVariable String name) {
        return ResponseEntity.ok(service.getLocationByName(name));
    }

    @GetMapping("/country/{country}")
    public ResponseEntity<GenericResponse> getLocationByCountry(@PathVariable String country) {
        return ResponseEntity.ok(service.getLocationByCountry(country));
    }
}
