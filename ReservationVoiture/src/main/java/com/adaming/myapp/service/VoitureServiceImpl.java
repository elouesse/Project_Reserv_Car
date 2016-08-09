package com.adaming.myapp.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adaming.myapp.Exception.ExceptionDispoVoiture;
import com.adaming.myapp.dao.IVoitureDao;
import com.adaming.myapp.entities.Voiture;

@Service
@Transactional
public class VoitureServiceImpl implements IVoitureService {
	
	@Autowired
	private IVoitureDao daoVoiture;

	public void setDaoVoiture(IVoitureDao daoVoiture) {
		this.daoVoiture = daoVoiture;
	}

	@Override
	public Voiture addVoiture(Voiture v) {
		return daoVoiture.addVoiture(v);
	}

	@Override
	public Voiture getVoiture(Long id) {
		return daoVoiture.getVoiture(id);
	}

	@Override
	public Voiture updateVoiture(Voiture v) {
		return daoVoiture.updateVoiture(v);
	}

	@Override
	public Voiture deleteVoiture(Long id) {
		return daoVoiture.deleteVoiture(id);
	}

	@Override
	public List<Voiture> getVoitures() {
		return daoVoiture.getVoitures();
	}

	@Override
	public List<Voiture> getVoituresDisp() throws ExceptionDispoVoiture {
		return daoVoiture.getVoituresDisp();
	}

	@Override
	public List<Voiture> getVoituresDispByPeriod(Date d1, Date d2) throws ExceptionDispoVoiture {
		return daoVoiture.getVoituresDispByPeriod(d1, d2);
	}

	@Override
	public Boolean alertEntretien(Long idV, Long idE, Double pref) {
		return daoVoiture.alertEntretien(idV, idE, pref);
		
	}

	@Override
	public List<Voiture> retourVoitures() {
		return daoVoiture.retourVoitures();
	}

}
