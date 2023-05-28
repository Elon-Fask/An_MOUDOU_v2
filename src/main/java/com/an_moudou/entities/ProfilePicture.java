package com.an_moudou.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Profile")

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfilePicture {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@Column(name="name", nullable=false, length=50)
    private String name;
    
	@Column(name="type", nullable=false, length=50)
    private String type;
	
    @Lob
    @Column(name = "imagedata")
    private byte[] imageData;
	
	@OneToOne(fetch=FetchType.LAZY, mappedBy="profile_image")
	private Client client ;
}
