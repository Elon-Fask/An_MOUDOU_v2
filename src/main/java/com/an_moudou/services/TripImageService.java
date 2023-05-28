package com.an_moudou.services;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.an_moudou.entities.TripImage;
import com.an_moudou.repositories.TripImageRepository;

@Service
public class TripImageService implements ServiceInterface<TripImage>  {
	
	@Autowired
	private TripImageRepository imageRep;
	
	@Override
	public List<TripImage> getAll() {
		return imageRep.findAll();
	}

	@Override
	public Optional<TripImage> getById(long id) {
		return imageRep.findById(id);
	}
	
	@Override
	public TripImage add(TripImage image) {
		return imageRep.saveAndFlush(image);
	}

	@Override
	public TripImage update(TripImage image) {
		return imageRep.saveAndFlush(image);
	}

	@Override
	public boolean delete(long id) {
		try {
			imageRep.deleteById(id);
			return true;
		}
		catch (Exception e){ e.printStackTrace(); }
		return false;
	}
}