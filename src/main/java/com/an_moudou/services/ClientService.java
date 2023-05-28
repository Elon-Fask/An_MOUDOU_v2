package com.an_moudou.services;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.an_moudou.entities.Client;
import com.an_moudou.repositories.ClientRepository;

@Service
public class ClientService implements ServiceInterface<Client>  {
	
	@Autowired
	private ClientRepository clientRep;
	
	@Override
	public List<Client> getAll() {
		return clientRep.findAll();
	}

	@Override
	public Optional<Client> getById(long id) {
		return clientRep.findById(id);
	}
	
	@Override
	public Client add(Client client) {
		return clientRep.saveAndFlush(client);
	}

	@Override
	public Client update(Client client) {
		return clientRep.saveAndFlush(client);
	}

	@Override
	public boolean delete(long id) {
		try {
			clientRep.deleteById(id);
			return true;
		}
		catch (Exception e){ e.printStackTrace(); }
		return false;
	}
}