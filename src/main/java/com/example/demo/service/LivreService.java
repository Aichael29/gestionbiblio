package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entities.Livre;
import com.example.demo.repos.LivreRepo;

@Service
public class LivreService {
	
	@Autowired
	private LivreRepo repos;
	
	public Livre saveLivre(Livre livre) {
		return repos.save(livre);		
	}
	
	public List<Livre> getLivres(){
		return repos.findAll();
	}
	
	public Livre getLivreById(int id){
		Optional<Livre> livre = repos.findById(id);
		if(livre.isPresent()){
			return livre.get();
		}
		throw new RuntimeException("not found");
	}
	
	public String deleteLivre(int id) {
		Optional<Livre> livre = repos.findById(id);
		if(livre.isPresent()){
			repos.deleteById(id);
			return "Livre supprimé "+ id;
		}
		throw new RuntimeException("not found");
	}
	
	public Livre updateLivre(int id, Livre livre) {
		Livre beforeup = repos.findById(livre.getId()).get();
		beforeup.setTitre(livre.getTitre());
		beforeup.setDate_sortie(livre.getDate_sortie());
		beforeup.setAuteur(livre.getAuteur());
		beforeup.setNombre_page(livre.getNombre_page());
		beforeup.setDerniere_consultation(livre.getDerniere_consultation());
		beforeup.setDisponibilite(livre.isDisponibilite());
		return repos.save(beforeup);
	}
	
	
	
	

}
