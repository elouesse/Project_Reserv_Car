/**
 * 
 */
package com.adaming.myapp.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author Eli
 *
 */
@Entity
public class Voiture {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idvoiture;
    private String model;
    private String immatricule;
    private Double kilometrage;
    private double prix;
    private String typeVoiture;
    private String typeCarburant;
    private String etatVoiture;
    
    
    //Association
    @OneToMany(mappedBy="voiture")
    private List<Reservation> reserv;
    
    //Constructors
	public Voiture() {
		super();
	}
	
	public Voiture(String model, String immatricule, Double kilometrage,
			double prix, String typeVoiture, String typeCarburant,
			String etatVoiture) {
		super();
		this.model = model;
		this.immatricule = immatricule;
		this.kilometrage = kilometrage;
		this.prix = prix;
		this.typeVoiture = typeVoiture;
		this.typeCarburant = typeCarburant;
		this.etatVoiture = etatVoiture;
	}
	
	
	
	public Long getIdvoiture() {
		return idvoiture;
	}
	public void setIdvoiture(Long idvoiture) {
		this.idvoiture = idvoiture;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getImmatricule() {
		return immatricule;
	}
	public void setImmatricule(String immatricule) {
		this.immatricule = immatricule;
	}
	public Double getKilometrage() {
		return kilometrage;
	}
	public void setKilometrage(Double kilometrage) {
		this.kilometrage = kilometrage;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public String getTypeVoiture() {
		return typeVoiture;
	}
	public void setTypeVoiture(String typeVoiture) {
		this.typeVoiture = typeVoiture;
	}
	public String getTypeCarburant() {
		return typeCarburant;
	}
	public void setTypeCarburant(String typeCarburant) {
		this.typeCarburant = typeCarburant;
	}
	public String getEtatVoiture() {
		return etatVoiture;
	}
	public void setEtatVoiture(String etatVoiture) {
		this.etatVoiture = etatVoiture;
	}

	public List<Reservation> getReserv() {
		return reserv;
	}

	public void setReserv(List<Reservation> reserv) {
		this.reserv = reserv;
	}


}
