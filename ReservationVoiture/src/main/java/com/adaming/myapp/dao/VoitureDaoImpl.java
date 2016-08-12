package com.adaming.myapp.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
		Query req = em.createQuery("from Voiture");
		List<Voiture> tabV = req.getResultList();
		List<Voiture> tab = new ArrayList<Voiture>();
		for(Voiture v:tabV)
		{
			if(v.getReserv().isEmpty())
			{
				tab.add(v);
			}
		}
		log.info("La liste de voitures disponibles contient "+tab.size());
		if(tab.isEmpty())
			throw new ExceptionDispoVoiture("");
		return tab;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Voiture> getVoituresDispByPeriod(Date d1, Date d2) throws ExceptionDispoVoiture {
		
		Query query= em.createQuery("select Distinct voiture from Reservation");
		List<Voiture>  list2 = query.getResultList();
		List<Voiture>  list = query.getResultList();

		List<Voiture>  tabV = getVoituresDisp();
		log.info("!!!!!!!!!!!!!!!!!!!!!!! la liste list contient : " +list.size());
		log.info("!!!!!!!!!!!!!!!!!!!!!!! la liste tabV contient : " +tabV.size());

		for(Voiture v: list)
		{
			log.info("!!!!!!!!!!!!!!!!!! la voiture v : "+ v.getIdvoiture()+" contient "+v.getReserv().size());
			for (Reservation r : v.getReserv()){
				log.info(r.getDateDeRentrer());
				log.info(r.getDateDeSortie());
			
				 if((r.getDateDeSortie().getTime()>=d1.getTime() && r.getDateDeSortie().getTime()<=d2.getTime()) || (r.getDateDeRentrer().getTime()<=d2.getTime() && r.getDateDeRentrer().getTime()>=d1.getTime()))
				 {
					list2.remove(v);
					log.info("!!!!!!!!!!!!!!!!!!! on passe dans le second if");
					break;
				}
			}
			log.info("!!!!!!!!!!!!!!!!!!!!!!! la liste list contient : " +list.size());
			continue;
		}
		log.info("!!!!!!!!!!!!!!!!!!!!!!! la liste list2 apres la boucle contient : " +list2.size());
		for(Voiture v : list2)
		{
			tabV.add(v);
		}
		if(tabV.isEmpty())
		{
			throw new ExceptionDispoVoiture("il n'y a aucune voiture disponible");
		}
		log.info("La liste de voitures disponibles contient "+tabV.size());
		return tabV;
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

	@SuppressWarnings("unchecked")
	@Override
	public Boolean alertEntretien(Long idV, Long idE, Double pref) {
		Voiture v = em.find(Voiture.class, idV);
		Query req = em.createQuery("from Entretien e where e.voiture.idvoiture=:x order by e.dateEntretient desc");
		req.setParameter("x",idV);
		List<Entretien> tab = req.getResultList();
		log.info("L'entretien recupere est le "+tab.get(0).getIdEntretient());
//		Entretien e = em.find(Entretien.class, idE);
		if(tab.get(0).getVoiture()!=v)
		{
			
		}
		if(pref<=(v.getKilometrage()-tab.get(0).getKilommetrage()))
		{
			log.info("Cette voiture a besoin d'un entretien");
			return true;
		}
		else
			log.info("Cette voiture a besoin d'un entretien");
			return false;
		
		
	}



	

	

}
