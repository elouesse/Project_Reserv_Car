package com.adaming.myapp.dao;

import java.util.List;

import com.adaming.myapp.entities.Agence;

public interface IAgenceDao {

	public Agence addAgence(Agence agence);
	public List<Agence> getAgences();
	public Agence getAgenceById(Long idA);
	public Agence updateAgence(Agence agence);
}
