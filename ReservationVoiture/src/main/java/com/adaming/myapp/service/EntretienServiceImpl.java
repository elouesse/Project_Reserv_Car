package com.adaming.myapp.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adaming.myapp.dao.IEntretienDao;
import com.adaming.myapp.entities.ChaineDistribution;
import com.adaming.myapp.entities.Entretien;
import com.adaming.myapp.entities.FiltreHuile;
import com.adaming.myapp.entities.Vidange;

@Service
@Transactional
public class EntretienServiceImpl implements IEntretienService{

	
	
	
	@Autowired
	private IEntretienDao daoEntretien;

	Logger log = Logger.getLogger("EntretienServiceImpl");
	
	
	
	public void setDaoEntretien(IEntretienDao daoEntretien) {
		this.daoEntretien = daoEntretien;
	}

	@Override
	public Entretien addEntretien(Entretien entretien, Long idV) {
		// TODO Auto-generated method stub
		return daoEntretien.addEntretien(entretien, idV);
	}

	@Override
	public Entretien getEntretienById(Long idE) {
		// TODO Auto-generated method stub
		return daoEntretien.getEntretienById(idE);
	}

	@Override
	public List<Entretien> getEntretiens() {
		// TODO Auto-generated method stub
		return daoEntretien.getEntretiens();
	}

	@Override
	public List<Entretien> getEntretiensOfOneCar(Long idV) {
		// TODO Auto-generated method stub
		return daoEntretien.getEntretiensOfOneCar(idV);
	}

	@Override
	public Entretien deleteEntretien(Long idE) {
		// TODO Auto-generated method stub
		return daoEntretien.deleteEntretien(idE);
	}

	@Override
	public Entretien updateEntretien(Entretien entretien) {
		// TODO Auto-generated method stub
		return daoEntretien.updateEntretien(entretien);
	}

	@Override
	public Vidange getLastVidange(Long idV) {
		// TODO Auto-generated method stub
		return daoEntretien.getLastVidange(idV);
	}

	@Override
	public ChaineDistribution getLastChaineD(Long idV) {
		// TODO Auto-generated method stub
		return daoEntretien.getLastChaineD(idV);
	}

	@Override
	public FiltreHuile getLastFilteH(Long idV) {
		// TODO Auto-generated method stub
		return daoEntretien.getLastFilteH(idV);
	}
}
