package com.an_moudou.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Reservations")

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@Column(name="reservation_code", nullable=false, length=50)
	private String reser_code ;
	
	@Column(name="reservation_date", nullable=false, length=50)
	private String reser_date ;
	
	@Column(name="details", nullable=false, length=512)
	private String details ;
	
	@Column(name="stats", nullable=false)
	private Boolean stats ;
	

	@ManyToOne(targetEntity = Client.class , fetch = FetchType.LAZY)
	@JoinColumn(name = "client_id" , insertable = false , updatable = false)
	private Client client ;
	
	@ManyToOne(targetEntity = Trip.class , fetch = FetchType.LAZY)
	@JoinColumn(name = "trip_id" , insertable = false , updatable = false)
	private Trip trip ;
	
}
