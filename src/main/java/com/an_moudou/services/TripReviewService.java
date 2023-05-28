package com.an_moudou.services;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.an_moudou.entities.TripReview;
import com.an_moudou.repositories.TripReviewRepository;

@Service
public class TripReviewService implements ServiceInterface<TripReview>  {
	
	@Autowired
	private TripReviewRepository tripReviewRep;
	
	@Override
	public List<TripReview> getAll() {
		return tripReviewRep.findAll();
	}

	@Override
	public Optional<TripReview> getById(long id) {
		return tripReviewRep.findById(id);
	}
	
	@Override
	public TripReview add(TripReview tripReview) {
		return tripReviewRep.saveAndFlush(tripReview);
	}

	@Override
	public TripReview update(TripReview tripReview) {
		return tripReviewRep.saveAndFlush(tripReview);
	}

	@Override
	public boolean delete(long id) {
		try {
			tripReviewRep.deleteById(id);
			return true;
		}
		catch (Exception e){ e.printStackTrace(); }
		return false;
	}
}