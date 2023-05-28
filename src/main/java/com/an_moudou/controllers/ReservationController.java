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

import com.an_moudou.entities.Reservation;
import com.an_moudou.services.ReservationService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ReservationController {
	@Autowired
	private ReservationService reservationService;
	
	@GetMapping("/reservations")
	public List<Reservation> getAllReservation(){
		return reservationService.getAll();
	}		
	
	@PostMapping("/reservation")
	public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservations) {
		Reservation createdReservation = reservationService.add(reservations); 
		//Reservation createdReservation = reservationrep.save(reservation); 
		 return ResponseEntity.ok(createdReservation);
	}		

	@GetMapping("/reservation/{id}")
	public Optional<Reservation> getReservationById(@PathVariable Long id) {
		return reservationService.getById(id);
	}
	
	@PutMapping("/reservation/{id}")
	public ResponseEntity<Reservation> updateReservation(@PathVariable Long id, @RequestBody Reservation reservationDetails){
		Reservation updatedReservation = reservationService.update(reservationDetails);
		return ResponseEntity.ok(updatedReservation);
	}
	
	@DeleteMapping("/reservation/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteReservation(@PathVariable Long id){
		reservationService.delete(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
