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

import com.an_moudou.entities.TripReview;
import com.an_moudou.services.TripReviewService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TripReviewController {
	@Autowired
	private TripReviewService tripreviewService;
	
	@GetMapping("/tripreviews")
	public List<TripReview> getAllTripReview(){
		return tripreviewService.getAll();
	}		
	
	@PostMapping("/tripreview")
	public ResponseEntity<TripReview> createTripReview(@RequestBody TripReview tripreviews) {
		TripReview createdTripReview = tripreviewService.add(tripreviews); 
		//TripReview createdTripReview = tripreviewrep.save(tripreview); 
		 return ResponseEntity.ok(createdTripReview);
	}		

	@GetMapping("/tripreview/{id}")
	public Optional<TripReview> getTripReviewById(@PathVariable Long id) {
		return tripreviewService.getById(id);
	}
	
	@PutMapping("/tripreview/{id}")
	public ResponseEntity<TripReview> updateTripReview(@PathVariable Long id, @RequestBody TripReview tripreviewDetails){
		TripReview updatedTripReview = tripreviewService.update(tripreviewDetails);
		return ResponseEntity.ok(updatedTripReview);
	}
	
	@DeleteMapping("/tripreview/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteTripReview(@PathVariable Long id){
		tripreviewService.delete(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
