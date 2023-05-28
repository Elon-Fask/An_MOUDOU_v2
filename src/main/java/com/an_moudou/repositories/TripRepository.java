package com.an_moudou.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.an_moudou.entities.Trip;

@CrossOrigin("*")

public interface TripRepository extends JpaRepository<Trip,Long> {

}
