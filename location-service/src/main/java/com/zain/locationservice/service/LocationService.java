package com.zain.locationservice.service;

import com.zain.locationservice.model.Location;
import com.zain.locationservice.model.GenericResponse;
import com.zain.locationservice.repo.LocationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    private final LocationRepo repo;

    @Autowired
    public LocationService(LocationRepo repo) {
        this.repo = repo;
    }

    public GenericResponse getLocationByName(String name) {
        List<Location> locations = repo.findByNameIgnoreCaseContaining(name);

        if (locations.isEmpty())
            return new GenericResponse(false, "No location found", null);
        else
            return new GenericResponse(true, "Location found", locations);
    }

    public GenericResponse getLocationByCountry(String country) {
        List<Location> locations = repo.findByCountryIgnoreCaseContaining(country);

        if (locations.isEmpty())
            return new GenericResponse(false, "No location found", null);
        else
            return new GenericResponse(true, "Location found", locations);
    }
}
