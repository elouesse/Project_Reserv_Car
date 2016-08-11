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
	@Autowired
	private IAgenceDao daoAgence;
	
	Logger log = Logger.getLogger("AgenceServiceImpl");


	

	public void setDaoAgence(IAgenceDao daoAgence) {
		this.daoAgence = daoAgence;
	}

	@Override
	public Agence addAgence(Agence agence) {
		// TODO Auto-generated method stub
		return daoAgence.addAgence(agence);
	}

	@Override
	public List<Agence> getAgences() {
		// TODO Auto-generated method stub
		return daoAgence.getAgences();
	}

	@Override
	public Agence getAgenceById(Long idA) {
		// TODO Auto-generated method stub
		return daoAgence.getAgenceById(idA);
	}

	@Override
	public Agence updateAgence(Agence agence) {
		// TODO Auto-generated method stub
		return daoAgence.updateAgence(agence);
	}
	
}
