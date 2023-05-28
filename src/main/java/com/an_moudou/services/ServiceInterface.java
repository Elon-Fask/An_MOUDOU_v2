package com.an_moudou.services;

import java.util.List;
import java.util.Optional;

public interface ServiceInterface<Type> {

	Type add(Type objet);
	
	List<Type> getAll();
	
	Optional<Type> getById(long id);
	
	Type update(Type objet);
	
	boolean delete(long id);
	
}
