package com.adaming.myapp.dao;
import java.util.Date;
import java.util.List;

import com.adaming.myapp.entities.Entretien;
import com.adaming.myapp.entities.Voiture;

public interface IVoitureDao {
	
	public Voiture addVoiture(Voiture c);
	public Voiture getVoiture(Long id);
	public Voiture updateVoiture(Voiture c);
	public Voiture deleteVoiture(Long id);
	public List<Voiture> getVoitures();
	public List<Voiture> getVoituresDisp();
	public List<Voiture> getVoituresDispByPeriod(Date d1, Date d2);
	public void alertEntretien(Long idV,Entretien e,Double pref);
	public List<Voiture> retourVoitures();

}
