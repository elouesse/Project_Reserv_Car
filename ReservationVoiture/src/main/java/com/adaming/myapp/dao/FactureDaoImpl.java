package com.adaming.myapp.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.adaming.myapp.entities.Agence;
import com.adaming.myapp.entities.Facture;
import com.adaming.myapp.entities.Reservation;

/*
 * 
 * author : thomas bernard
 */
@Repository(value="daoFacture")
public class FactureDaoImpl implements IFactureDao{

	@PersistenceContext
	private EntityManager em;	
	
	Logger log = Logger.getLogger("FactureDaoImpl");
	
	@Override
	public Facture addFacture(Long idA, Long idR, Facture f) {
		
		Agence a = em.find(Agence.class, idA);
		Reservation r = em.find(Reservation.class, idR);
		f.setReservation(r);
		a.getListFacture().add(f);
		em.merge(a);
		em.persist(f);
		log.info("la facture pour le client :"+f.getReservation().getClient().getNom()+"a bien été ajouté");
		return f;
	}

	@Override
	public Facture getFactureById(Long idF) {
		
		Facture f = em.find(Facture.class, idF);
		log.info("on recupere la facture d'id : "+f.getIdFacture());
		return f;
	}

	@Override
	public List<Facture> getFactures() {
		Query query = em.createQuery("FROM Facture");
		log.info("on recupère les factures");
		return query.getResultList();
	}

	@Override
	public List<Facture> getFactureOfOneCar(Long idC) {
		Query query = em.createQuery("FROM Facture f where f.reservation.voiture.idvoiture=:x ");
		query.setParameter("x", idC);
		log.info("on recupère les factures d'une voiture");
		return query.getResultList();
	}

	@Override
	public List<Facture> getFactureOfOneClient(Long idC) {
		Query query = em.createQuery("FROM Facture f where f.reservation.client.idClient=:x ");
		query.setParameter("x", idC);
		log.info("on recupère les factures d'un client");
		return query.getResultList();
	}

}
