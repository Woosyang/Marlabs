package com.example.demo;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// must be consistent with the table name
@Entity
public class City {
	// all the name of field must be the lower case
	// when connecting to the database
	private int id;
	private String name;
	private String weatherdescription;
	private String temperature;
	
	public City() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Id // From JPA
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWeatherdescription() {
		return weatherdescription;
	}

	public void setWeatherdescription(String weatherdescription) {
		this.weatherdescription = weatherdescription;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
}
