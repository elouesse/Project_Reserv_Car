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
public class Entretien {

	//attribut
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idEntretient;
	private String typeEntretient;
	private Date dateEntretient;
	private  Double Kilommetrage;
	private Integer prixEntrtient;
	
	//association
	@ManyToOne
	@JoinColumn(name="idVoiture")
	private Voiture voiture;

	
	//getter and setter
	public Long getIdEntretient() {
		return idEntretient;
	}

	public void setIdEntretient(Long idEntretient) {
		this.idEntretient = idEntretient;
	}

	public String getTypeEntretient() {
		return typeEntretient;
	}

	public void setTypeEntretient(String typeEntretient) {
		this.typeEntretient = typeEntretient;
	}

	public Date getDateEntretient() {
		return dateEntretient;
	}

	public void setDateEntretient(Date dateEntretient) {
		this.dateEntretient = dateEntretient;
	}

	public Double getKilommetrage() {
		return Kilommetrage;
	}

	public void setKilommetrage(Double kilommetrage) {
		Kilommetrage = kilommetrage;
	}

	public Integer getPrixEntrtient() {
		return prixEntrtient;
	}

	public void setPrixEntrtient(Integer prixEntrtient) {
		this.prixEntrtient = prixEntrtient;
	}

	public Voiture getVoiture() {
		return voiture;
	}

	public void setVoiture(Voiture voiture) {
		this.voiture = voiture;
	}

	
	
	//constructor
	


	public Entretien(Date dateEntretient, Double kilommetrage,
			Integer prixEntrtient) {
		super();
		this.dateEntretient = dateEntretient;
		Kilommetrage = kilommetrage;
		this.prixEntrtient = prixEntrtient;
	}

	public Entretien() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
