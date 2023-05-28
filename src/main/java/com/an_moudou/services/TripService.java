package com.an_moudou.services;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.an_moudou.entities.Trip;
import com.an_moudou.repositories.TripRepository;

@Service
public class TripService implements ServiceInterface<Trip>  {
	
	@Autowired
	private TripRepository tripRep;
	
	@Override
	public List<Trip> getAll() {
		return tripRep.findAll();
	}

	@Override
	public Optional<Trip> getById(long id) {
		return tripRep.findById(id);
	}
	
	@Override
	public Trip add(Trip trip) {
		return tripRep.saveAndFlush(trip);
	}

	@Override
	public Trip update(Trip trip) {
		return tripRep.saveAndFlush(trip);
	}

	@Override
	public boolean delete(long id) {
		try {
			tripRep.deleteById(id);
			return true;
		}
		catch (Exception e){ e.printStackTrace(); }
		return false;
	}
}