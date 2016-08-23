package com.adaming.myapp.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.adaming.myapp.entities.Agence;
import com.adaming.myapp.entities.Client;
/*
 * 
 * author : thomas bernard
 */

@Repository(value="dao")
public class AgenceDaoImpl implements IAgenceDao {

	@PersistenceContext
	private EntityManager em;	
	
	Logger log = Logger.getLogger("AgenceDaoImpl");
	
	@Override
	public Agence addAgence(Agence agence) {
		// TODO Auto-generated method stub
		em.persist(agence);
		log.info("l'agence "+"a completer"+" a bien été ajouté");
		return agence ;
	}

	@Override
	public List<Agence> getAgences() {
		Query query = em.createQuery("from Agence");
		log.info("on recuper la liste des Agences");
		return query.getResultList();
	}

	@Override
	public Agence getAgenceById(Long idA) {
		Agence a = em.find(Agence.class, idA);
		log.info("on recuper l'agence  "+"a completer");;
		return a;
	}

	@Override
	public Agence updateAgence(Agence agence) {
		em.merge(agence);
		log.info("l'agence a ete modifier a completer");
		return agence;
	}

}
