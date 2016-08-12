package com.adaming.myapp.bean;



import java.util.ArrayList;

import java.util.Iterator;

import java.util.List;



import javax.annotation.PostConstruct;

import javax.faces.application.FacesMessage;

import javax.faces.bean.ApplicationScoped;

import javax.faces.bean.RequestScoped;

import javax.faces.bean.SessionScoped;

import javax.faces.context.FacesContext;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;



import com.adaming.myapp.entities.Entretien;

import com.adaming.myapp.entities.Voiture;

import com.adaming.myapp.service.IEntretienService;

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

	

	@Autowired

	private IEntretienService serviceEntretien;



	private List<Voiture> voitures = new ArrayList<Voiture>();

	private Voiture voiture;

	

	private List<Entretien> entretiens = new ArrayList<Entretien>();

	private Entretien entretien;



	private Long idvoiture;

	private String model;

	private String immatricule;

	private Double kilometrage;

	private double prix;

	private String typeVoiture;

	private String typeCarburant;

	private String etatVoiture;

	



	private List<String> carburants = new ArrayList<String>();



	/*

	 * METHODES

	 */



	@PostConstruct

	public void init() {

		voitures = serviceVoiture.getVoitures();

	}

	

	public void refreshListe() {

		voitures = serviceVoiture.getVoitures();

	}

	

	public void getEntretien () {

		entretiens = serviceEntretien.getEntretiensOfOneCar(idvoiture);

		for (Entretien e : entretiens){    

            e.setTypeEntretient(e.getClass().getSimpleName());    

        }    

	}

	

	public void deleteVoiture() {

		entretiens = serviceEntretien.getEntretiensOfOneCar(idvoiture);

		Iterator<Entretien> iteEnt = entretiens.iterator();

		

		while (iteEnt.hasNext()) {

			serviceEntretien.deleteEntretien(iteEnt.next().getIdEntretient());

		}

		

		voiture = serviceVoiture.deleteVoiture(idvoiture);

		confirmationDelete();

		refreshListe();

	}

	

	public void confirmationDelete() {

		addMessage("Succes", "La voiture a bien été supprimee");

	}

	

	public void addMessage(String summary, String detail) {

		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_FATAL, summary, detail);

		FacesContext.getCurrentInstance().addMessage(null, message);

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



	public Voiture getVoiture() {

		return voiture;

	}



	public void setVoiture(Voiture voiture) {

		this.voiture = voiture;

	}



	public List<String> getCarburants() {

		return carburants;

	}



	public void setCarburants(List<String> carburants) {

		this.carburants = carburants;

	}



	public IEntretienService getServiceEntretien() {

		return serviceEntretien;

	}



	public void setServiceEntretien(IEntretienService serviceEntretien) {

		this.serviceEntretien = serviceEntretien;

	}



	public List<Entretien> getEntretiens() {

		return entretiens;

	}



	public void setEntretiens(List<Entretien> entretiens) {

		this.entretiens = entretiens;

	}



	public void setEntretien(Entretien entretien) {

		this.entretien = entretien;

	}



}