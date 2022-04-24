package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Livre;
import com.example.demo.service.LivreService;

@RestController
public class LivreController {
	
	@Autowired
	private LivreService service;
	
	@PostMapping("/emsi_api/addLivre")
	public Livre addLivre(@RequestBody Livre livre) {
		try {
		return service.saveLivre(livre);
		}
		catch(Exception e) {
			throw new RuntimeException("change ISBN"); 
		}
	}
	
	
	@GetMapping("/emsi_api/livres")
	public List<Livre> findAllLivres(){
		return service.getLivres();
	}
	
	
	@GetMapping("/emsi_api/livres/{id}")
	public Livre findLivreById(@PathVariable int id){
		return service.getLivreById(id);
	}
	
	
	
	@PutMapping("/emsi_api/updateLivre/{id}")
	public Livre updateLivre(@PathVariable int id, @RequestBody Livre livre) {
		return service.updateLivre(id,livre);
	}
	
	@DeleteMapping("emsi_api/deleteLivre/{id}")
	public String deleteLivre(@PathVariable int id) {
		return service.deleteLivre(id);
	}
	

}
