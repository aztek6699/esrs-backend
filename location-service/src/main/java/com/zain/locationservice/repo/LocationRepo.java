package com.zain.locationservice.repo;

import com.zain.locationservice.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepo extends JpaRepository<Location, Long> {

    List<Location> findByNameIgnoreCaseContaining(String name);
    List<Location> findByCountryIgnoreCaseContaining(String country);
}
