package com.an_moudou.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.an_moudou.entities.ProfilePicture;

@CrossOrigin("*")

public interface ProfilePictureRepository extends JpaRepository<ProfilePicture,Long>{

}
