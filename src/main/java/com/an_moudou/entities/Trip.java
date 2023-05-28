package com.an_moudou.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Trips")

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trip {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;

	@Column(name="title", nullable=false, length=50)
	private String title;
	
	@Column(name="description", nullable=false, length=512)
	private String description ;
	
	@Column(name="transport", nullable=false, length=50)
	private String transport ;

	@Column(name="hotel", nullable=false, length=100)
	private String hotel ;

	@Column(name="start_date", nullable=false, length=50)
	private Date start_date ;

	@Column(name="end_date", nullable=false, length=50)
	private Date end_date ;

	@Column(name="deadline", nullable=false, length=50)
	private Date deadline ;

	@Column(name="capacity", nullable=false, length=50)
	private Long capacity ;

	@Column(name="available_capacity", nullable=false, length=50)
	private Long available_capacity ;
	
	@Column(name="fee", nullable=false, length=50)
	private double fee ;

	@Column(name="location", nullable=false, length=50)
	private String location ;
	
	@ManyToMany
	@JoinTable(
		name="Trip_Images",
		joinColumns=@JoinColumn(name="Trip_ID"),
		inverseJoinColumns=@JoinColumn(name="Image_ID"))
	private List<TripImage> tripImages;
	
	@OneToMany(mappedBy = "trip")
	private List<Reservation> reservations;
	
	@ManyToOne(targetEntity = Users.class , fetch = FetchType.LAZY)
	@JoinColumn(name = "owner_id" , insertable = false , updatable = false)
	private Users owner ;
	
}
