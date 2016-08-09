/**
 * 
 */
package com.adaming.myapp.entities;

import java.util.Date;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * @author Thomas Bernard
 *
 */
public class Facture {

	//attribut
	private Long idFacture;
	private Date DateDeFacturation;
	//association
	@OneToOne
	@JoinColumn(name="idReservation")
	private Reservation reservation;
	
	//constructors
	public Facture() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Facture(Date dateDeFacturation) {
		super();
		DateDeFacturation = dateDeFacturation;
	}
	//getter and setter
	public Long getIdFacture() {
		return idFacture;
	}
	public void setIdFacture(Long idFacture) {
		this.idFacture = idFacture;
	}
	public Date getDateDeFacturation() {
		return DateDeFacturation;
	}
	public void setDateDeFacturation(Date dateDeFacturation) {
		DateDeFacturation = dateDeFacturation;
	}
	public Reservation getReservation() {
		return reservation;
	}
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	
	
	
}
