package com.an_moudou.services;

import com.an_moudou.entities.Users;
import com.an_moudou.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService implements ServiceInterface<Users>  {

//	private UserDao userDao;
//	private PasswordEncoder passwordEncoder;
	@Autowired
	private UsersRepository userRep;
//	public UsersService(UserDao userDao, PasswordEncoder passwordEncoder){
//		this.userDao = userDao;
//		this.passwordEncoder = passwordEncoder;
//	}

	@Override
	public List<Users> getAll() {
		return userRep.findAll();
	}

	@Override
	public Optional<Users> getById(long id) {
		return userRep.findById(id);
	}
	
	@Override
	public Users add(Users user) {
		return userRep.saveAndFlush(user);
	}

	@Override
	public Users update(Users user) {
		return userRep.saveAndFlush(user);
	}

	@Override
	public boolean delete(long id) {
		try {
			userRep.deleteById(id);
			return true;
		}
		catch (Exception e){ e.printStackTrace(); }
		return false;
	}

//	public int insertUser(Users users) {
//		users.setPassword(passwordEncoder.encode(users.getPassword()));
//		return userDao.insertUser(users);
//
//	}
//
//	public void loadUserByUsername(String email) {
//	}
//
//	public void activateAccount(String email) {
//	}
}

