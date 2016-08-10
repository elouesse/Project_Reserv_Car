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

	
	
	
	
	private IEntretienDao dao;

	Logger log = Logger.getLogger("EntretienServiceImpl");
	
	
	public void setDao(IEntretienDao dao) {
		this.dao = dao;
		log.info("<-----------------dao Entretien injected------------------>");
	}

	@Override
	public Entretien addEntretien(Entretien entretien, Long idV) {
		// TODO Auto-generated method stub
		return dao.addEntretien(entretien, idV);
	}

	@Override
	public Entretien getEntretienById(Long idE) {
		// TODO Auto-generated method stub
		return dao.getEntretienById(idE);
	}

	@Override
	public List<Entretien> getEntretiens() {
		// TODO Auto-generated method stub
		return dao.getEntretiens();
	}

	@Override
	public List<Entretien> getEntretiensOfOneCar(Long idV) {
		// TODO Auto-generated method stub
		return dao.getEntretiensOfOneCar(idV);
	}

	@Override
	public Entretien deleteEntretien(Long idE) {
		// TODO Auto-generated method stub
		return dao.deleteEntretien(idE);
	}

	@Override
	public Entretien updateEntretien(Entretien entretien) {
		// TODO Auto-generated method stub
		return dao.updateEntretien(entretien);
	}

	@Override
	public Vidange getLastVidange(Long idV) {
		// TODO Auto-generated method stub
		return dao.getLastVidange(idV);
	}

	@Override
	public ChaineDistribution getLastChaineD(Long idV) {
		// TODO Auto-generated method stub
		return dao.getLastChaineD(idV);
	}

	@Override
	public FiltreHuile getLastFilteH(Long idV) {
		// TODO Auto-generated method stub
		return dao.getLastFilteH(idV);
	}
}
