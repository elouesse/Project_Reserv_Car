package com.adaming.myapp.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

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
	private Voiture voiture;

	private Long idvoiture;
	private String model;
	private String immatricule;
	private Double kilometrage;
	private double prix;
	private String typeVoiture;
	private String typeCarburant;
	private String etatVoiture;
	

	private final static String[] carburants;

	private final static String[] modeles;

	private final static String[] types;

	private final static String[] etats;

	static {
        carburants = new String[4];
        carburants[0] = "essence 95";
        carburants[1] = "super 98 e10";
        carburants[2] = "Diesel";
        carburants[3] = "GPL";
     
        modeles = new String[10];
        modeles[0] = "BMW";
        modeles[1] = "Mercedes";
        modeles[2] = "Volvo";
        modeles[3] = "Audi";
        modeles[4] = "Renault";
        modeles[5] = "Fiat";
        modeles[6] = "Volkswagen";
        modeles[7] = "Honda";
        modeles[8] = "Jaguar";
        modeles[9] = "Ford";
        
        types = new String[3];
        types[0] = "espace";
        types[1] = "citadine";
        types[2] = "4x4";
        
        etats = new String[2];
        etats[0] = "Neuve";
        etats[1] = "Occasion";
    }

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

	public Voiture getVoiture() {
		return voiture;
	}

	public void setVoiture(Voiture voiture) {
		this.voiture = voiture;
	}

}
