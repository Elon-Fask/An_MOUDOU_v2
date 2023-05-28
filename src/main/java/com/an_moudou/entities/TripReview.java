package com.an_moudou.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Trip_Reviews")

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TripReview {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@Column(name="review", nullable=false, length=50)
	private String review ;
	
	@ManyToOne(targetEntity = Client.class , fetch = FetchType.LAZY)
	@JoinColumn(name = "client_id" , insertable = false , updatable = false)
	private Client client ;
	
}

