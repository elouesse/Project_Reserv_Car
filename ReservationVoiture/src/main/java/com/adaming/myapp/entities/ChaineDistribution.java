/**
 * 
 */
package com.adaming.myapp.entities;

import java.util.Date;

import javax.persistence.Entity;

/**
 * @author thomas bernard
 *
 */
@Entity
public class ChaineDistribution extends Entretien {

	public ChaineDistribution() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChaineDistribution(Date dateEntretient, Double kilommetrage,
			Integer prixEntrtient) {
		super(dateEntretient, kilommetrage, prixEntrtient);
		// TODO Auto-generated constructor stub
	}

}
