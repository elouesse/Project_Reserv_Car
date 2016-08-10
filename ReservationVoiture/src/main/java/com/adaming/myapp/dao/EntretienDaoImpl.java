package com.adaming.myapp.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.adaming.myapp.entities.Agence;
import com.adaming.myapp.entities.ChaineDistribution;
import com.adaming.myapp.entities.Entretien;
import com.adaming.myapp.entities.FiltreHuile;
import com.adaming.myapp.entities.Vidange;
import com.adaming.myapp.entities.Voiture;

@Repository(value="daoEntretien")
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
		Query query = em.createQuery("from Entretien e where e.voiture.idvoiture=:x");
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

	@Override
	public Vidange getLastVidange(Long idV) {
		Query query = em.createQuery("from Vidange e where e.voiture.idvoiture=:x  order by e.dateEntretient desc");
		query.setParameter("x", idV);
		log.info("on recupère le dernier entretien Vidange de la voiture :"+ ((Entretien) query.getResultList().get(0)).getVoiture().getModel());
		return (Vidange) query.getResultList().get(0);
	}

	@Override
	public ChaineDistribution getLastChaineD(Long idV) {
		Query query = em.createQuery("from ChaineDistribution e where e.voiture.idvoiture=:x  order by e.dateEntretient desc");
		query.setParameter("x", idV);
		log.info("on recupère le dernier entretien ChaineDistribution de la voiture :"+ ((Entretien) query.getResultList().get(0)).getVoiture().getModel());
		return (ChaineDistribution) query.getResultList().get(0);
	}

	@Override
	public FiltreHuile getLastFilteH(Long idV) {
		Query query = em.createQuery("from FiltreHuile e where e.voiture.idvoiture=:x  order by e.dateEntretient desc");
		query.setParameter("x", idV);
		log.info("on recupère le dernier entretien FiltreHuile de la voiture :"+ ((Entretien) query.getResultList().get(0)).getVoiture().getModel());
		return (FiltreHuile) query.getResultList().get(0);
	}

	
}
