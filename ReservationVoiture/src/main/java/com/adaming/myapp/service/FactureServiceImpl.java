package com.adaming.myapp.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adaming.myapp.dao.IFactureDao;
import com.adaming.myapp.entities.Facture;

@Service
@Transactional
public class FactureServiceImpl implements IFactureService{

	
	@Autowired
	private IFactureDao daoFacture;
	Logger log = Logger.getLogger("FactureServiceImpl");



	public void setDaoFacture(IFactureDao daoFacture) {
		this.daoFacture = daoFacture;
	}

	@Override
	public Facture addFacture(Long idA, Long idR, Facture f) {
		// TODO Auto-generated method stub
		return daoFacture.addFacture(idA, idR, f);
	}

	@Override
	public Facture getFactureById(Long idF) {
		// TODO Auto-generated method stub
		return daoFacture.getFactureById(idF);
	}

	@Override
	public List<Facture> getFactures() {
		// TODO Auto-generated method stub
		return daoFacture.getFactures();
	}

	@Override
	public List<Facture> getFactureOfOneCar(Long idC) {
		// TODO Auto-generated method stub
		return daoFacture.getFactureOfOneCar(idC);
	}

	@Override
	public List<Facture> getFactureOfOneClient(Long idC) {
		// TODO Auto-generated method stub
		return daoFacture.getFactureOfOneClient(idC);
	}

	@Override
	public double coutFacture(Long idF) {
		Facture f = daoFacture.getFactureById(idF);
		return f.getReservation().getPrix();
	}

	@Override
	public double coutFacturesFromClient(Long idC) {
		
		double prixTot=0;
		List<Facture> list = daoFacture.getFactureOfOneClient(idC);
		for(Facture f : list)
		{
			prixTot= prixTot+f.getReservation().getPrix();
		}
		log.info("le prix totale des factures facture du client d'id "+ idC + " est " +prixTot);
		return prixTot;
	}

	@Override
	public double coutFacturesFromCar(Long idV) {
		double prixTot=0;
		List<Facture> list = daoFacture.getFactureOfOneCar(idV);
		for(Facture f : list)
		{
			prixTot= prixTot+f.getReservation().getPrix();
		}
		log.info("le prix totale des facture de la voiture d'id "+ idV + " est " +prixTot);
		return prixTot;
	}
	
	
	
}
