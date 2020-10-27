package org.tutorial3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.tutorial3.entities.CountryModel;
import org.tutorial3.repositories.CountryRepository;

@SpringBootApplication
public class CountriesApplication implements CommandLineRunner{

	//ÖĞRENİLENLER
	
	//org.springframework.boot
		//SpringApplication.run(java.lang.Class<?> primarySource, java.lang.String... args)   :ApplicationContext
	
	 @Autowired
	 private CountryRepository countryRepository;
	 
	 public static void main(String[] args) {
		SpringApplication.run(CountriesApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		countryRepository.save(new CountryModel("Earh", "World"));
		countryRepository.save(new CountryModel("Chine", "Peking"));
		countryRepository.save(new CountryModel("German", "Berlin"));
		countryRepository.save(new CountryModel("USA", "Washington"));
		countryRepository.save(new CountryModel("Russia", "Moscow"));
		countryRepository.save(new CountryModel("Namibia", "Windhoek"));
		countryRepository.save(new CountryModel("India", "Delhi"));
		countryRepository.save(new CountryModel("Türkiye", "İstanbul"));
		countryRepository.save(new CountryModel("Türkiye", "İstanbul"));
		countryRepository.save(new CountryModel("Türkiye", "İstanbul"));


	}
	 

	
}
