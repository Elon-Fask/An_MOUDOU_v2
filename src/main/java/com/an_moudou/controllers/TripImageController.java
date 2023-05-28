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

import com.an_moudou.entities.TripImage;
import com.an_moudou.services.TripImageService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TripImageController {
	@Autowired
	private TripImageService imageService;
	
	@GetMapping("/images")
	public List<TripImage> getAllTripImage(){
		return imageService.getAll();
	}		
	
	@PostMapping("/image")
	public ResponseEntity<TripImage> createTripImage(@RequestBody TripImage images) {
		TripImage createdTripImage = imageService.add(images); 
		//TripImage createdTripImage = imagerep.save(image); 
		 return ResponseEntity.ok(createdTripImage);
	}		

	@GetMapping("/image/{id}")
	public Optional<TripImage> getTripImageById(@PathVariable Long id) {
		return imageService.getById(id);
	}
	
	@PutMapping("/image/{id}")
	public ResponseEntity<TripImage> updateTripImage(@PathVariable Long id, @RequestBody TripImage imageDetails){
		TripImage updatedTripImage = imageService.update(imageDetails);
		return ResponseEntity.ok(updatedTripImage);
	}
	
	@DeleteMapping("/image/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteTripImage(@PathVariable Long id){
		imageService.delete(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
