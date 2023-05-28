package com.an_moudou.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Messeges")

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Messege {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@Column(name="full_name", nullable=false, length=50)
	private String full_name ;
	
	@Column(name="email", nullable=false, length=50)
	private String email ;
	
	@Column(name="subject", nullable=false, length=50)
	private String subject ;
	
	@Column(name="message", nullable=false, length=512)
	private String message ;

}
