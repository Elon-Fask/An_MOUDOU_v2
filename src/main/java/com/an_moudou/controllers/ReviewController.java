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

import com.an_moudou.entities.Review;
import com.an_moudou.services.ReviewService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ReviewController {
	@Autowired
	private ReviewService reviewService;
	
	@GetMapping("/reviews")
	public List<Review> getAllReview(){
		return reviewService.getAll();
	}		
	
	@PostMapping("/review")
	public ResponseEntity<Review> createReview(@RequestBody Review reviews) {
		Review createdReview = reviewService.add(reviews); 
		//Review createdReview = reviewrep.save(review); 
		 return ResponseEntity.ok(createdReview);
	}		

	@GetMapping("/review/{id}")
	public Optional<Review> getReviewById(@PathVariable Long id) {
		return reviewService.getById(id);
	}
	
	@PutMapping("/review/{id}")
	public ResponseEntity<Review> updateReview(@PathVariable Long id, @RequestBody Review reviewDetails){
		Review updatedReview = reviewService.update(reviewDetails);
		return ResponseEntity.ok(updatedReview);
	}
	
	@DeleteMapping("/review/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteReview(@PathVariable Long id){
		reviewService.delete(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
