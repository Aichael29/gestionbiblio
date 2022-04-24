package com.example.demo.entities;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

import lombok.*;

@Entity @Table(name="livre")
@Data @AllArgsConstructor @NoArgsConstructor

public class Livre {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	
	@Column(nullable=false,length=50)@OrderBy
	private String Titre;
	
	@Column(nullable=false,updatable=false)
	private String Maison_edition;
	
	@Temporal(TemporalType.DATE)
	private Date  Date_sortie;
	
	@Column(nullable=false)
	private String Auteur;
	
	@Column(nullable=false)
	private int nombre_page;
	
	@Column(nullable=false,unique=true, updatable=false)
	private long ISBN;
	
	@Temporal(TemporalType.TIMESTAMP) @CreationTimestamp
	private Date derniere_consultation ;
	
	private boolean disponibilite;
	
	
	public Livre() {
		super();
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getTitre() {
		return Titre;
	}

	public void setTitre(String titre) {
		Titre = titre;
	}

	public Livre(Integer id, String titre, String maison_edition, Date date_sortie, String auteur, int nombre_page,
			long iSBN, Date derniere_consultation, boolean disponibilite) {
		super();
		Id = id;
		Titre = titre;
		Maison_edition = maison_edition;
		Date_sortie = date_sortie;
		Auteur = auteur;
		this.nombre_page = nombre_page;
		ISBN = iSBN;
		this.derniere_consultation = derniere_consultation;
		this.disponibilite = disponibilite;
	}

	public String getMaison_edition() {
		return Maison_edition;
	}

	public void setMaison_edition(String maison_edition) {
		Maison_edition = maison_edition;
	}

	public Date getDate_sortie() {
		return Date_sortie;
	}

	public void setDate_sortie(Date date_sortie) {
		Date_sortie = date_sortie;
	}

	public String getAuteur() {
		return Auteur;
	}

	public void setAuteur(String auteur) {
		Auteur = auteur;
	}

	public int getNombre_page() {
		return nombre_page;
	}

	public void setNombre_page(int nombre_page) {
		this.nombre_page = nombre_page;
	}

	public long getISBN() {
		return ISBN;
	}

	public void setISBN(long iSBN) {
		ISBN = iSBN;
	}

	public Date getDerniere_consultation() {
		return derniere_consultation;
	}

	public void setDerniere_consultation(Date derniere_consultation) {
		this.derniere_consultation = derniere_consultation;
	}

	public boolean isDisponibilite() {
		return disponibilite;
	}

	public void setDisponibilite(boolean disponibilite) {
		this.disponibilite = disponibilite;
	}
	
	
	
	
	
}
