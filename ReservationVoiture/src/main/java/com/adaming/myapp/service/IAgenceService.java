package com.adaming.myapp.service;

import java.util.List;

import com.adaming.myapp.entities.Agence;

public interface IAgenceService {

	
	public Agence addAgence(Agence agence);
	public List<Agence> getAgences();
	public Agence getAgenceById(Long idA);
	public Agence updateAgence(Agence agence);
}
