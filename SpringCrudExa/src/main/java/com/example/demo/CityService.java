package com.example.demo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

@Service
public class CityService {
	@Autowired
	private CityRepository cRepo;
	
	public List<City> listAll() {
		return cRepo.findAll(); // from JPA Repository
	}
	
	public void save(City city) {
		cRepo.save(city);
	}
	
	public City get(int id) {
		return cRepo.findById(id).get();
	}
	
	public void delete(int id) {
		cRepo.deleteById(id);
	}
}
