package com.adaming.myapp.dao;

import java.util.List;

import com.adaming.myapp.entities.Facture;

/*
 * 
 * author : thomas bernard
 */
public interface IFactureDao {

	public Facture addFacture(Long idA, Long idR, Facture f);
	public Facture getFactureById(Long idF);
	public List<Facture> getFactures();
	public List<Facture> getFactureOfOneCar(Long idC);
	public List<Facture> getFactureOfOneClient(Long idC);
	
	
}
