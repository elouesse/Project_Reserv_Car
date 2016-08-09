package com.adaming.myapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.adaming.myapp.entities.Client;
import com.adaming.myapp.entities.Reservation;
import com.adaming.myapp.entities.Voiture;

@Repository(value="daoReserv")
public class ReservationDaoImpl implements IReservationDao {
	
	@PersistenceContext
	private EntityManager em;
	
	private Logger log = Logger.getLogger("ReservationDaoImpl");

	@Override
	public Reservation addReservation(Reservation r, Long idClient,
			Long idVoiture) {
		Client c = em.find(Client.class, idClient);
		Voiture v= em.find(Voiture.class, idVoiture);
		r.setClient(c);
		r.setVoiture(v);
		em.persist(r);
		log.info("La reservation "+r.getIdreservation()+" a bien ete ajoute");
		return r;
	}

	@Override
	public Reservation getReservation(Long id) {
		Reservation r=em.find(Reservation.class, id);
		log.info("La reservation "+r.getIdreservation()+" a bien ete recupere");
		return r;
	}

	@Override
	public Reservation updateReservation(Reservation r) {
		em.merge(r);
		log.info("La reservation "+r.getIdreservation()+" a bien ete modifie");
		return r;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Reservation> getHistorique() {
		Query req = em.createQuery("from Reservation");
		log.info("La liste de reservations contient "+req.getResultList().size());
		return req.getResultList();
	}

}
