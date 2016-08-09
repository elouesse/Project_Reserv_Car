package com.adaming.myapp.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.adaming.myapp.Exception.ExceptionDispoVoiture;
import com.adaming.myapp.entities.Entretien;
import com.adaming.myapp.entities.Reservation;
import com.adaming.myapp.entities.Voiture;

@Repository(value="daoVoiture")
public class VoitureDaoImpl implements IVoitureDao {
	
	
	@PersistenceContext
	private EntityManager em;
	
	private Logger log = Logger.getLogger("VoitureDaoImpl");

	@Override
	public Voiture addVoiture(Voiture v) {
		em.persist(v);
		log.info("La voiture "+v.getIdvoiture()+" a bien ete ajoute");
		return v;
	}

	@Override
	public Voiture getVoiture(Long id) {
		Voiture v = em.find(Voiture.class, id);
		log.info("La voiture "+v.getIdvoiture()+" a bien ete recupere");
		return v;
	}

	@Override
	public Voiture updateVoiture(Voiture v) {
		em.merge(v);
		log.info("La voiture "+v.getIdvoiture()+" a bien ete modifie");
		return v;
	}

	@Override
	public Voiture deleteVoiture(Long id) {
		Voiture v = em.find(Voiture.class, id);
		em.remove(v);
		log.info("La voiture "+v.getIdvoiture()+" a bien ete supprime");
		return v;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Voiture> getVoitures() {
		Query req = em.createQuery("from Voiture");
		log.info("La liste de voitures contient "+req.getResultList().size());
		return req.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Voiture> getVoituresDisp() throws ExceptionDispoVoiture {
		Query req = em.createQuery("from Voiture v where v.Reservation==null");
		log.info("La liste de voitures disponibles contient "+req.getResultList().size());
		if(req.getResultList().isEmpty())
			throw new ExceptionDispoVoiture("");
		return req.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Voiture> getVoituresDispByPeriod(Date d1, Date d2) throws ExceptionDispoVoiture {
		Query req = em.createQuery("from Voiture where v.Reservation==null");
		Query req1 = em.createQuery("from Reservation");
		List<Voiture> tabV = req.getResultList();
		List<Reservation> tabR = req1.getResultList();
		List<Voiture> tab = new ArrayList<Voiture>();
		for(Voiture v:tabV)
		{
			for(Reservation r:tabR)
			{
				if(r.getVoiture()==v){
//					if(r.getDateDeSortie().before(d1)&&r.getDateDeRentrer().after(d2)
//							||r.getDateDeSortie().after(d1)&&r.getDateDeRentrer().before(d2)
//							||r.getDateDeSortie().before(d1)&&r.getDateDeRentrer().after(d1)
//							||r.getDateDeSortie().before(d2)&&r.getDateDeRentrer().after(d2))
//					{
//						continue;
//					}
					if(r.getDateDeSortie().before(d1)&&r.getDateDeRentrer().before(d2)
							||r.getDateDeSortie().after(d1)&&r.getDateDeRentrer().after(d2)
							||r.getDateDeSortie().after(d1)&&r.getDateDeSortie().after(d2)
							||r.getDateDeRentrer().before(d1)&&r.getDateDeRentrer().before(d2))
					{
						tab.add(v);
					}
				}
			}	
			log.info("La liste de voitures disponibles pour cette periode contient "+tab.size());
		}
		if(tab.isEmpty())
			throw new ExceptionDispoVoiture("");
		return tab;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Voiture> retourVoitures() {
		Date today = new Date();
		Query req = em.createQuery("from Reservation r where r.dateDeRentrer=:x");
		req.setParameter("x", today);
		List<Reservation> tabR = req.getResultList();
		List<Voiture> tabV = new ArrayList<Voiture>();
		for(Reservation r:tabR)
		{
			tabV.add(r.getVoiture());
		}
		log.info("La liste de voitures pour un retour Aujourd'hui contient "+tabV.size());
		return tabV;
	}

	@Override
	public Boolean alertEntretien(Long idV, Long idE, Double pref) {
		Voiture v = em.find(Voiture.class, idV);
		Entretien e = em.find(Entretien.class, idE);
		if(e.getVoiture()!=v)
		{
			
		}
		if(pref<=(v.getKilometrage()-e.getKilommetrage()))
		{
			log.info("Cette voiture a besoin d'un entretien");
			return true;
		}
		else
			log.info("Cette voiture a besoin d'un entretien");
			return false;
		
		
	}



	

	

}
