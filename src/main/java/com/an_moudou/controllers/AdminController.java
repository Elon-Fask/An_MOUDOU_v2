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

import com.an_moudou.entities.Admin;
import com.an_moudou.services.AdminService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/admins")
	public List<Admin> getAllAdmin(){
		return adminService.getAll();
	}		
	
	@PostMapping("/admin")
	public ResponseEntity<Admin> createAdmin(@RequestBody Admin admins) {
		Admin createdAdmin = adminService.add(admins); 
		//Admin createdAdmin = adminrep.save(admin); 
		 return ResponseEntity.ok(createdAdmin);
	}		

	@GetMapping("/admin/{id}")
	public Optional<Admin> getAdminById(@PathVariable Long id) {
		return adminService.getById(id);
	}
	
	@PutMapping("/admin/{id}")
	public ResponseEntity<Admin> updateAdmin(@PathVariable Long id, @RequestBody Admin adminDetails){
		Admin updatedAdmin = adminService.update(adminDetails);
		return ResponseEntity.ok(updatedAdmin);
	}
	
	@DeleteMapping("/admin/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteAdmin(@PathVariable Long id){
		adminService.delete(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
