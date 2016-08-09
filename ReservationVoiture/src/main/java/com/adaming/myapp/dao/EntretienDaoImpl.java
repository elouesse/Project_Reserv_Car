package com.adaming.myapp.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.adaming.myapp.entities.Agence;
import com.adaming.myapp.entities.Entretien;
import com.adaming.myapp.entities.Voiture;

public class EntretienDaoImpl implements IEntretienDao {

	@PersistenceContext
	private EntityManager em;	
	
	Logger log = Logger.getLogger("EntretienDaoImpl");
	@Override
	public Entretien addEntretien(Entretien entretien, Long idV) {
		
		Voiture v = em.find(Voiture.class, idV);
		entretien.setVoiture(v);
		em.persist(entretien);
		log.info("l'entretien pour la voiture" + "a completer"+" a bien été ajouté" );
		return entretien;
	}

	@Override
	public Entretien getEntretienById(Long idE) {
		
		Entretien e = em.find(Entretien.class, idE);
		log.info("on recupère l'entretien  de la date : "+e.getDateEntretient());;
		return e;
	}

	@Override
	public List<Entretien> getEntretiens() {
		Query query = em.createQuery("from Entretien");
		log.info("on recuper la liste des Entretiens");
		return query.getResultList();
	}

	@Override
	public List<Entretien> getEntretiensOfOneCar(Long idV) {
		Query query = em.createQuery("from Entretien e where e.voiture.idVoiture=:x");
		query.setParameter("x", idV);
		log.info("on recupère les entretien de la voiture : "+"a completer");
		return query.getResultList();
	}

	@Override
	public Entretien deleteEntretien(Long idP) {
		Entretien e = em.find(Entretien.class, idP);
		em.remove(e);
		log.info("l'entretien d'id " +e.getIdEntretient()+"a bien été supprimer");
		return e;
	}

	@Override
	public Entretien updateEntretien(Entretien entretien) {
		em.merge(entretien);
		log.info("l'entretien d'id :"+entretien.getIdEntretient()+" a ete modifier");
		return entretien;
	}

}
