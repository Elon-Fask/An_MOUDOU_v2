package com.an_moudou.services;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.an_moudou.entities.Reservation;
import com.an_moudou.repositories.ReservationRepository;

@Service
public class ReservationService implements ServiceInterface<Reservation>  {
	
	@Autowired
	private ReservationRepository reservationRep;
	
	@Override
	public List<Reservation> getAll() {
		return reservationRep.findAll();
	}

	@Override
	public Optional<Reservation> getById(long id) {
		return reservationRep.findById(id);
	}
	
	@Override
	public Reservation add(Reservation reservation) {
		return reservationRep.saveAndFlush(reservation);
	}

	@Override
	public Reservation update(Reservation reservation) {
		return reservationRep.saveAndFlush(reservation);
	}

	@Override
	public boolean delete(long id) {
		try {
			reservationRep.deleteById(id);
			return true;
		}
		catch (Exception e){ e.printStackTrace(); }
		return false;
	}
}