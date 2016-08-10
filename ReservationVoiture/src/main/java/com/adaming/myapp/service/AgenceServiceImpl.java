package com.adaming.myapp.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adaming.myapp.dao.IAgenceDao;
import com.adaming.myapp.entities.Agence;


@Service
@Transactional
public class AgenceServiceImpl implements IAgenceService{

	private IAgenceDao dao;
	
	Logger log = Logger.getLogger("AgenceServiceImpl");


	public void setDao(IAgenceDao dao) {
		this.dao = dao;
		log.info("<-----------------dao Agence injected------------------>");
	}

	@Override
	public Agence addAgence(Agence agence) {
		// TODO Auto-generated method stub
		return dao.addAgence(agence);
	}

	@Override
	public List<Agence> getAgences() {
		// TODO Auto-generated method stub
		return dao.getAgences();
	}

	@Override
	public Agence getAgenceById(Long idA) {
		// TODO Auto-generated method stub
		return dao.getAgenceById(idA);
	}

	@Override
	public Agence updateAgence(Agence agence) {
		// TODO Auto-generated method stub
		return dao.updateAgence(agence);
	}
	
}
