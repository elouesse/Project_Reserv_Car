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
public class Vidange extends Entretien {

	public Vidange() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vidange(Date dateEntretient, Double kilommetrage,
			Integer prixEntrtient) {
		super(dateEntretient, kilommetrage, prixEntrtient);
		// TODO Auto-generated constructor stub
	}

}
