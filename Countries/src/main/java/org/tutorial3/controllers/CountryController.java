package org.tutorial3.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tutorial3.entities.CountryModel;
import org.tutorial3.repositories.CountryRepository;

import com.google.gson.Gson;

@Controller
public class CountryController {
	
	//ÖĞRENİLENLER
	
	//org.springframework.web
		//@GetMapping
		//@PostMapping
		//@ResponseBody ***
		//@RequestParam ***
		//@Autowired
	
	//org.springframework.data
		//org.springframework.data.repository
			//CrudRepository.JpaRepository.save(S entity) 	
			//CrudRepository.JpaRepository.deleteById(ID id)
			//PagingAndSortingRepository.JpaRepository.findAll(Pageable pageable)
	
	//org.springframework.data
		//org.springframework.data.domain
			//PageRequest.of(int page,int size) :::PageRequest implementation of Pageable interface 
		
	//org.springframework.ui
		//Model.addAttribute(String attributeName, @Nullable Object attributeValue)
	
	
	//bazı notlar
		//entity == JsonObj == OBJ == MODELCLASS
	
	@Autowired
	private CountryRepository countryRepo;
	
	//GET http://localhost:8080/ veya http://localhost:8080/?page=1//  findAll ile tüm verileri alma,// adresine client, request yaptığında bu kısım çalışır
	@GetMapping("/")
	public String showPage(Model model, @RequestParam(defaultValue = "0") int page) { // @RequestParam clientden gönderilen url parametresinde page karşısındaki değeri alır. mesela page= 4 
		model.addAttribute(		//direk index.html'de  dataObjArr 'e erişmek için kullandık bunu
				"dataObjArr", 
				countryRepo.findAll(PageRequest.of(page, 4))
		);
		
		model.addAttribute("currentPage", page); //direk index.html'de  currentPage 'e erişmek için kullandık bunu

		//inceleme yaptım
		//String dataObjArr = new Gson().toJson(model.getAttribute("dataObjArr"));	 //output == {"total":10,"content":[{"id":1,"name":"Earh","capital":"World"},{"id":2,"name":"Chine","capital":"Peking"},{"id":3,"name":"German","capital":"Berlin"},{"id":4,"name":"USA","capital":"Washington"}],"pageable":{"sort":{"orders":[]},"page":0,"size":4}}
		//String modelJson = new Gson().toJson(model); 	  //output == modelJson::: {"dataObjArr":{"total":10,"content":[{"id":1,"name":"Earh","capital":"World"},{"id":2,"name":"Chine","capital":"Peking"},{"id":3,"name":"German","capital":"Berlin"},{"id":4,"name":"USA","capital":"Washington"}],"pageable":{"sort":{"orders":[]},"page":0,"size":4}}}		
				
		return "index";	//cliente verilen cevap:: index.html renderle ve cliente göster
	}
	
	//POST http://localhost:8080/save //SAVE ile obje ekleme veya varsa update etme
	 @PostMapping("/save")
	 public String save(CountryModel c) {
		countryRepo.save(c);
		System.out.println("c::"+c); //c çıktısı :: Country [id=1, name=Earh, capital=World]
		return "redirect:/";   //server cevap olarak http://localhost:8080/ adresine yönlendirir
	 }
	 
	//GET http://localhost:8080/delete/?id=5  //DELETE ile obje silme  
	 @GetMapping("/delete")
	 public String deleteCountry(Integer id) {
		 countryRepo.deleteById(id);
		 return "redirect:/"; //server cevap olarak http://localhost:8080/ adresine yönlendirir
	 }
	 
	 
	 //GET http://localhost:8080/findOne/?id=2  //FİNDBYID ile eşleşen id ile 1 obje bulma
	 @GetMapping("/findOne")
	 @ResponseBody
	 public Optional<CountryModel> findOne(Integer id) {
		 return countryRepo.findById(id); //@ResponseBody sayesinde server json tipinde cevap verilir //clientte çıktısı {"id":2,"name":"Chine","capital":"Peking"}
 
	 }
	 
	 
}
