package com.adaming.myapp.dao;

import java.util.List;

import com.adaming.myapp.entities.Entretien;

public interface IEntretienDao {

	
	
	public Entretien addEntretien(Entretien entretien, Long idV);
	public Entretien getEntretienById(Long idE);
	public List<Entretien> getEntretiens();
	public List<Entretien> getEntretiensOfOneCar(Long idV);
	public Entretien deleteEntretien(Long idE);
	public Entretien updateEntretien(Entretien entretien);
}
