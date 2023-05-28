package com.an_moudou.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.an_moudou.entities.ProfilePicture;
import com.an_moudou.repositories.ProfilePictureRepository;

@Service
public class ProfilePictureService implements ServiceInterface<ProfilePicture>  {
	
	@Autowired
	private ProfilePictureRepository profilePicRep;
	
	@Override
	public List<ProfilePicture> getAll() {
		return profilePicRep.findAll();
	}

	@Override
	public Optional<ProfilePicture> getById(long id) {
		return profilePicRep.findById(id);
	}
	
	@Override
	public ProfilePicture add(ProfilePicture profilePic) {
		return profilePicRep.saveAndFlush(profilePic);
	}

	@Override
	public ProfilePicture update(ProfilePicture profilePic) {
		return profilePicRep.saveAndFlush(profilePic);
	}

	@Override
	public boolean delete(long id) {
		try {
			profilePicRep.deleteById(id);
			return true;
		}
		catch (Exception e){ e.printStackTrace(); }
		return false;
	}

}
