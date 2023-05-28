package com.an_moudou.services;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.an_moudou.entities.Review;
import com.an_moudou.repositories.ReviewRepository;

@Service
public class ReviewService implements ServiceInterface<Review>  {
	
	@Autowired
	private ReviewRepository reviewRep;
	
	@Override
	public List<Review> getAll() {
		return reviewRep.findAll();
	}

	@Override
	public Optional<Review> getById(long id) {
		return reviewRep.findById(id);
	}
	
	@Override
	public Review add(Review review) {
		return reviewRep.saveAndFlush(review);
	}

	@Override
	public Review update(Review review) {
		return reviewRep.saveAndFlush(review);
	}

	@Override
	public boolean delete(long id) {
		try {
			reviewRep.deleteById(id);
			return true;
		}
		catch (Exception e){ e.printStackTrace(); }
		return false;
	}
}