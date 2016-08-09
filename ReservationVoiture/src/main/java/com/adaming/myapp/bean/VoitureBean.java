package com.adaming.myapp.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.adaming.myapp.entities.Voiture;
import com.adaming.myapp.service.IVoitureService;

/*
 * @ERIK DUHEM
 * 09 08 2016
 * V1
 */

@Component("VoitureBean")
@RequestScoped
public class VoitureBean {

	/*
	 * ATTRIBUTS
	 */

	@Autowired
	private IVoitureService serviceVoiture;

	private List<Voiture> voitures = new ArrayList<Voiture>();

	private Long idvoiture;
	private String model;
	private String immatricule;
	private Double kilometrage;
	private double prix;
	private String typeVoiture;
	private String typeCarburant;
	private String etatVoiture;
	
	/*
	 * METHODES
	 */
	
	@PostConstruct
	public void getListeVoiture() {
		voitures = serviceVoiture.getVoitures();
	}
	

	/*
	 * CONSTRUCTEURS
	 */

	public VoitureBean() {
		super();
	}

	/*
	 * ACCESSEURS
	 */

	public IVoitureService getServiceVoiture() {
		return serviceVoiture;
	}

	public void setServiceVoiture(IVoitureService serviceVoiture) {
		this.serviceVoiture = serviceVoiture;
	}

	public List<Voiture> getVoitures() {
		return voitures;
	}

	public void setVoitures(List<Voiture> voitures) {
		this.voitures = voitures;
	}

	public Long getIdvoiture() {
		return idvoiture;
	}

	public void setIdvoiture(Long idvoiture) {
		this.idvoiture = idvoiture;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getImmatricule() {
		return immatricule;
	}

	public void setImmatricule(String immatricule) {
		this.immatricule = immatricule;
	}

	public Double getKilometrage() {
		return kilometrage;
	}

	public void setKilometrage(Double kilometrage) {
		this.kilometrage = kilometrage;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getTypeVoiture() {
		return typeVoiture;
	}

	public void setTypeVoiture(String typeVoiture) {
		this.typeVoiture = typeVoiture;
	}

	public String getTypeCarburant() {
		return typeCarburant;
	}

	public void setTypeCarburant(String typeCarburant) {
		this.typeCarburant = typeCarburant;
	}

	public String getEtatVoiture() {
		return etatVoiture;
	}

	public void setEtatVoiture(String etatVoiture) {
		this.etatVoiture = etatVoiture;
	}

}
