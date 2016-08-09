package com.adaming.myapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.adaming.myapp.entities.Client;

@Repository(value="daoClient")
public class ClientDaoImpl implements IClientdao {
	
	@PersistenceContext
	private EntityManager em;
	
	private Logger log = Logger.getLogger("ClientDaoImpl");

	@Override
	public Client addClient(Client c) {
		em.persist(c);
		log.info("Le client "+c.getIdClient()+" a bien ete ajoute");
		return c;
	}

	@Override
	public Client getClient(Long id) {
		Client c = em.find(Client.class, id);
		log.info("Le client "+c.getIdClient()+" a bien ete recupere");
		return c;
	}

	@Override
	public Client updateClient(Client c) {
		em.merge(c);
		log.info("Le client "+c.getIdClient()+" a bien ete modifie");
		return c;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Client> getClients() {
		Query req = em.createQuery("from Client");
		log.info("La liste de clients contient "+req.getResultList().size());
		return req.getResultList();
	}

}
