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

import com.an_moudou.entities.ProfilePicture;
import com.an_moudou.services.ProfilePictureService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProfilePictureController {
	@Autowired
	private ProfilePictureService profileService;
	
	@GetMapping("/profiles")
	public List<ProfilePicture> getAllProfilePicture(){
		return profileService.getAll();
	}		
	
	@PostMapping("/profile")
	public ResponseEntity<ProfilePicture> createProfilePicture(@RequestBody ProfilePicture profiles) {
		ProfilePicture createdProfilePicture = profileService.add(profiles); 
		//ProfilePicture createdProfilePicture = profilerep.save(profile); 
		 return ResponseEntity.ok(createdProfilePicture);
	}		

	@GetMapping("/profile/{id}")
	public Optional<ProfilePicture> getProfilePictureById(@PathVariable Long id) {
		return profileService.getById(id);
	}
	
	@PutMapping("/profile/{id}")
	public ResponseEntity<ProfilePicture> updateProfilePicture(@PathVariable Long id, @RequestBody ProfilePicture profileDetails){
		ProfilePicture updatedProfilePicture = profileService.update(profileDetails);
		return ResponseEntity.ok(updatedProfilePicture);
	}
	
	@DeleteMapping("/profile/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteProfilePicture(@PathVariable Long id){
		profileService.delete(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
