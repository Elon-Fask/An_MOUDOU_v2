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

import com.an_moudou.entities.Messege;
import com.an_moudou.services.MessegeService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MessegeController {
	@Autowired
	private MessegeService messegeService;
	
	@GetMapping("/messeges")
	public List<Messege> getAllMessege(){
		return messegeService.getAll();
	}		
	
	@PostMapping("/messege")
	public ResponseEntity<Messege> createMessege(@RequestBody Messege messeges) {
		Messege createdMessege = messegeService.add(messeges); 
		//Messege createdMessege = messegerep.save(messege); 
		 return ResponseEntity.ok(createdMessege);
	}		

	@GetMapping("/messege/{id}")
	public Optional<Messege> getMessegeById(@PathVariable Long id) {
		return messegeService.getById(id);
	}
	
	@PutMapping("/messege/{id}")
	public ResponseEntity<Messege> updateMessege(@PathVariable Long id, @RequestBody Messege messegeDetails){
		Messege updatedMessege = messegeService.update(messegeDetails);
		return ResponseEntity.ok(updatedMessege);
	}
	
	@DeleteMapping("/messege/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteMessege(@PathVariable Long id){
		messegeService.delete(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
