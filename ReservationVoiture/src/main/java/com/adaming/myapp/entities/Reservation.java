/**
 * 
 */
package com.adaming.myapp.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author Eli
 *
 */
@Entity
public class Reservation {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idreservation;
	private double prix;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date dateDeReservation;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date dateDeRentrer;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date dateDeSortie;
	private String heureDeSortie;
	private String heureDeRentrer;
	private Integer nombresDeJours;
	private String etatDeReservation;
	
	//Association
	@ManyToOne
	@JoinColumn(name="ID_Client")
    private Client client;
    @ManyToOne
    @JoinColumn(name="ID_Voiture")
    private Voiture voiture;
    
    //Constructors
    public Reservation() {
		super();
	}
	
	public Reservation(double prix, Date dateDeReservation, Date dateDeRentrer,
			Date dateDeSortie, String heureDeSortie, String heureDeRentrer,
			Integer nombresDeJours, String etatDeReservation) {
		super();
		this.prix = prix;
		this.dateDeReservation = dateDeReservation;
		this.dateDeRentrer = dateDeRentrer;
		this.dateDeSortie = dateDeSortie;
		this.heureDeSortie = heureDeSortie;
		this.heureDeRentrer = heureDeRentrer;
		this.nombresDeJours = nombresDeJours;
		this.etatDeReservation = etatDeReservation;
	}
	
	
	public Long getIdreservation() {
		return idreservation;
	}
	public void setIdreservation(Long idreservation) {
		this.idreservation = idreservation;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public Date getDateDeReservation() {
		return dateDeReservation;
	}
	public void setDateDeReservation(Date dateDeReservation) {
		this.dateDeReservation = dateDeReservation;
	}
	public Date getDateDeRentrer() {
		return dateDeRentrer;
	}
	public void setDateDeRentrer(Date dateDeRentrer) {
		this.dateDeRentrer = dateDeRentrer;
	}
	public Date getDateDeSortie() {
		return dateDeSortie;
	}
	public void setDateDeSortie(Date dateDeSortie) {
		this.dateDeSortie = dateDeSortie;
	}
	public String getHeureDeSortie() {
		return heureDeSortie;
	}
	public void setHeureDeSortie(String heureDeSortie) {
		this.heureDeSortie = heureDeSortie;
	}
	public String getHeureDeRentrer() {
		return heureDeRentrer;
	}
	public void setHeureDeRentrer(String heureDeRentrer) {
		this.heureDeRentrer = heureDeRentrer;
	}
	public Integer getNombresDeJours() {
		return nombresDeJours;
	}
	public void setNombresDeJours(Integer nombresDeJours) {
		this.nombresDeJours = nombresDeJours;
	}
	public String getEtatDeReservation() {
		return etatDeReservation;
	}
	public void setEtatDeReservation(String etatDeReservation) {
		this.etatDeReservation = etatDeReservation;
	}
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Voiture getVoiture() {
		return voiture;
	}
	public void setVoiture(Voiture voiture) {
		this.voiture = voiture;
	}
	
	
	


}
