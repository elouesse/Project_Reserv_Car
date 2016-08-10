package com.adaming.myapp.service;

import java.util.List;

import com.adaming.myapp.entities.ChaineDistribution;
import com.adaming.myapp.entities.Entretien;
import com.adaming.myapp.entities.FiltreHuile;
import com.adaming.myapp.entities.Vidange;

public interface IEntretienService {

	
	
	public Entretien addEntretien(Entretien entretien, Long idV);
	public Entretien getEntretienById(Long idE);
	public List<Entretien> getEntretiens();
	public List<Entretien> getEntretiensOfOneCar(Long idV);
	public Entretien deleteEntretien(Long idE);
	public Entretien updateEntretien(Entretien entretien);
	public Vidange getLastVidange(Long idV);
	public ChaineDistribution getLastChaineD(Long idV);
	public FiltreHuile getLastFilteH(Long idV);
}
