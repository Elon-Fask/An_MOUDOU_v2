package com.an_moudou.entities;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Images")

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TripImage {

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

    @ManyToMany(mappedBy="tripImages")
	private List<Trip> trips;
}
