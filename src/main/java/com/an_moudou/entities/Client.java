package com.an_moudou.entities;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Clients")
//@DiscriminatorValue("Clients")

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client extends Users{

	
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "profile_image")
	private ProfilePicture profile_image ;
	
	@OneToMany(mappedBy = "client")
	private List<Reservation> resevations;
	
	@OneToMany(mappedBy ="client")
	private List<Review> reviews;
	
	@OneToMany(mappedBy ="client")
	private List<TripReview> tripReviews;
}
