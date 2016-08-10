package com.adaming.myapp.service;

import java.util.List;

import com.adaming.myapp.entities.Facture;

public interface IFactureService {

	
	public Facture addFacture(Long idA, Long idR, Facture f);
	public Facture getFactureById(Long idF);
	public List<Facture> getFactures();
	public List<Facture> getFactureOfOneCar(Long idC);
	public List<Facture> getFactureOfOneClient(Long idC);
	public double coutFacture(Long idF);
	public double coutFacturesFromClient(Long idC);
	public double coutFacturesFromCar(Long idV);
	
	
}
