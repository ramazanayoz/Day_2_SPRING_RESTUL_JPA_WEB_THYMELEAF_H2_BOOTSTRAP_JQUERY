package org.tutorial3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tutorial3.entities.CountryModel;

public interface CountryRepository extends JpaRepository<CountryModel, Integer>{ //integer represent type of primary key
	
}
