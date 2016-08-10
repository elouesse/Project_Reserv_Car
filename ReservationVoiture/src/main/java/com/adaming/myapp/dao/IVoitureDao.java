package com.adaming.myapp.dao;
import java.util.Date;
import java.util.List;

import com.adaming.myapp.Exception.ExceptionDispoVoiture;
import com.adaming.myapp.entities.Voiture;

public interface IVoitureDao {
	
	public Voiture addVoiture(Voiture c);
	public Voiture getVoiture(Long id);
	public Voiture updateVoiture(Voiture c);
	public Voiture deleteVoiture(Long id);
	public List<Voiture> getVoitures();
	public List<Voiture> getVoituresDisp() throws ExceptionDispoVoiture;
	public List<Voiture> getVoituresDispByPeriod(Date d1, Date d2) throws ExceptionDispoVoiture;
	public Boolean alertEntretien(Long idV, Long idE,Double pref);
	public List<Voiture> retourVoitures();

}
