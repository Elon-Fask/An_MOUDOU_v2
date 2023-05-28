package com.an_moudou.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.an_moudou.entities.Trip;
import com.an_moudou.services.TripService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TripController {
	@Autowired
	private TripService tripService;
	
	@GetMapping("/trips")
	public List<Trip> getAllTrip(){
		return tripService.getAll();
	}		
	
	@PostMapping("/trip")
	public ResponseEntity<Trip> createTrip(@RequestBody Trip trips) {
		Trip createdTrip = tripService.add(trips); 
		//Trip createdTrip = triprep.save(trip); 
		 return ResponseEntity.ok(createdTrip);
	}		

	@GetMapping("/trip/{id}")
	public Optional<Trip> getTripById(@PathVariable Long id) {
		return tripService.getById(id);
	}
	
	@PutMapping("/trip/{id}")
	public ResponseEntity<Trip> updateTrip(@PathVariable Long id, @RequestBody Trip tripDetails){
		Trip updatedTrip = tripService.update(tripDetails);
		return ResponseEntity.ok(updatedTrip);
	}
	
	@DeleteMapping("/trip/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteTrip(@PathVariable Long id){
		tripService.delete(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
