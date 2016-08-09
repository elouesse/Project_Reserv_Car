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
public class FiltreHuile extends Entretien {

	public FiltreHuile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FiltreHuile(Date dateEntretient, Double kilommetrage,
			Integer prixEntrtient) {
		super(dateEntretient, kilommetrage, prixEntrtient);
		// TODO Auto-generated constructor stub
	}

	
}
