package org.tutorial3.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@javax.persistence.Entity //classın entitiy(model) olduğunu belirtiyoruz
public class CountryModel {

	
	//ÖĞRENİLENLER 
	
	//javax.persistence
		//@Id
		//@GeneratedValue 
		//@javax.persistence.Entity
	
	
	
	@Id  //ID ile hangisi primary key olduğunu belirtiyoruz
	@GeneratedValue 	//primary key için otomatik key üretir, kendisi otomatik doldurur 
	private Integer id;
	private String name;
	private String capital;
	
	
	//constructur
	public CountryModel() {
	}
	
	public CountryModel(String name, String capital) {
		this.name = name;
		this.capital = capital;
	}


	//methods
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", name=" + name + ", capital=" + capital + "]";
	}
	
	
}
