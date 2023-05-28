package com.an_moudou.services;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.an_moudou.entities.Messege;
import com.an_moudou.repositories.MessegeRepository;

@Service
public class MessegeService implements ServiceInterface<Messege>  {
	
	@Autowired
	private MessegeRepository messegeRep;
	
	@Override
	public List<Messege> getAll() {
		return messegeRep.findAll();
	}

	@Override
	public Optional<Messege> getById(long id) {
		return messegeRep.findById(id);
	}
	
	@Override
	public Messege add(Messege messege) {
		return messegeRep.saveAndFlush(messege);
	}

	@Override
	public Messege update(Messege messege) {
		return messegeRep.saveAndFlush(messege);
	}

	@Override
	public boolean delete(long id) {
		try {
			messegeRep.deleteById(id);
			return true;
		}
		catch (Exception e){ e.printStackTrace(); }
		return false;
	}
}