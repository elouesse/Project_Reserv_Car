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
import javax.persistence.OneToOne;

/**
 * @author Thomas Bernard
 *
 */
@Entity
public class Facture {

	//attribut
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idFacture;
	private Date dateDeFacturation;
	
	//association
	@OneToOne
	@JoinColumn(name="idReservation")
	private Reservation reservation;
	@ManyToOne
	@JoinColumn(name="idAgence")
	private Agence agence;
	//constructors
	public Facture() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Facture(Date dateDeFacturation) {
		super();
		this.dateDeFacturation = dateDeFacturation;
	}
	//getter and setter
	public Long getIdFacture() {
		return idFacture;
	}
	public void setIdFacture(Long idFacture) {
		this.idFacture = idFacture;
	}
	public Date getDateDeFacturation() {
		return dateDeFacturation;
	}
	public void setDateDeFacturation(Date dateDeFacturation) {
		this.dateDeFacturation = dateDeFacturation;
	}
	public Reservation getReservation() {
		return reservation;
	}
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	
	
	
}
