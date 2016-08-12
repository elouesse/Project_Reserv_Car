package com.adaming.myapp.bean;



import java.util.ArrayList;

import java.util.Date;

import java.util.HashMap;

import java.util.List;

import java.util.Map;



import javax.annotation.PostConstruct;

import javax.faces.application.FacesMessage;

import javax.faces.bean.SessionScoped;

import javax.faces.context.FacesContext;

import javax.inject.Inject;



import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;



import com.adaming.myapp.dao.EntretienDaoImpl;

import com.adaming.myapp.dao.IEntretienDao;

import com.adaming.myapp.entities.ChaineDistribution;

import com.adaming.myapp.entities.Entretien;

import com.adaming.myapp.entities.FiltreHuile;

import com.adaming.myapp.entities.Vidange;

import com.adaming.myapp.entities.Voiture;

import com.adaming.myapp.service.IEntretienService;

import com.adaming.myapp.service.IVoitureService;



/*

 * @ErikDuhem

 * 10 08 2016

 * v1

 */



@Component("AddVoitureBean")

@SessionScoped

public class AddVoitureBean {



	private Logger log = Logger.getLogger("AddVoitureBean");



	@Autowired

	private IVoitureService serviceVoiture;



	@Autowired

	private IEntretienService serviceEntretien;



	private Long idVoiture;

	private String immatriculation;



	private Double kilometrage;



	private Double prix;



	private Vidange vidange;



	private FiltreHuile filtreHuile;



	private ChaineDistribution chaineDist;



	private List<Voiture> voitures = new ArrayList<Voiture>();

	private Voiture voiture;



	private String carburant;

	private Map<String, String> carburants = new HashMap<String, String>();



	private String modele;

	private Map<String, String> modeles = new HashMap<String, String>();



	private String etat;

	private Map<String, String> etats = new HashMap<String, String>();



	private String type;

	private Map<String, String> types = new HashMap<String, String>();



	private List<Entretien> listeEt = new ArrayList<Entretien>();

	private Entretien entretien;



	/*

	 * METHODES

	 */



	@PostConstruct

	public void init() {



		carburants = new HashMap<String, String>();

		carburants.put("Essence 95", "Essence 95");

		carburants.put("Super 98 e10", "Super 98 e10");

		carburants.put("Diesel", "Diesel");

		carburants.put("GPL", "GPL");



		modeles = new HashMap<String, String>();

		modeles.put("Renault", "Renault");

		modeles.put("BMW", "BMW");

		modeles.put("Volvo", "Volvo");

		modeles.put("Citroen", "Citroen");

		modeles.put("BatMobile", "BatMobile");

		modeles.put("Honda", "Honda");

		modeles.put("Hyundai", "Hyundai");

		modeles.put("Ford", "Ford");

		modeles.put("Seat", "Seat");

		modeles.put("Bentley", "Bentley");

		modeles.put("Fiat", "Fiat");



		etats = new HashMap<String, String>();

		etats.put("Neuve", "Neuve");

		etats.put("Abimee", "Abimee");



		types = new HashMap<String, String>();

		types.put("4x4", "4x4");

		types.put("Espace", "Espace");

		types.put("Citadine", "Citadine");

		types.put("Sport", "Sport");



	}



	public void addVoiture() {

		Voiture vtr = new Voiture(modele, immatriculation, kilometrage, prix, type, carburant, etat);

		setVoiture(serviceVoiture.addVoiture(vtr));

		setIdVoiture(voiture.getIdvoiture());

		addEntretient(idVoiture);

	}



	// public void getEntretiens() {

	// serviceEntretien.getEntretiens();

	// }



	public void addEntretient(Long idV) {

		setVidange(new Vidange(new Date(), kilometrage + 10000., 80));

		setFiltreHuile(new FiltreHuile(new Date(), kilometrage + 30000., 150));

		setChaineDist(new ChaineDistribution(new Date(), kilometrage + 70000., 600));

		

		serviceEntretien.addEntretien(getVidange(), idV);

		serviceEntretien.addEntretien(getFiltreHuile(), idV);

		serviceEntretien.addEntretien(getChaineDist(), idV);

	}



	public void confirmationAdd() {

		addMessage("Succes", "La voiture a bien été crée");

	}

	

	public void confirmationUpdate() {

		addMessage("Success", "La voiture a bien été mis a jour");

	}



	public void addMessage(String summary, String detail) {

		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);

		FacesContext.getCurrentInstance().addMessage(null, message);

	}



	/*

	 * CONSTRUCTEURS

	 */



	public AddVoitureBean() {

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



	public Voiture getVoiture() {

		return voiture;

	}



	public void setVoiture(Voiture voiture) {

		this.voiture = voiture;

	}



	public String getCarburant() {

		return carburant;

	}



	public void setCarburant(String carburant) {

		this.carburant = carburant;

	}



	public Map<String, String> getCarburants() {

		return carburants;

	}



	public void setCarburants(Map<String, String> carburants) {

		this.carburants = carburants;

	}



	public String getModele() {

		return modele;

	}



	public void setModele(String modele) {

		this.modele = modele;

	}



	public Map<String, String> getModeles() {

		return modeles;

	}



	public void setModeles(Map<String, String> modeles) {

		this.modeles = modeles;

	}



	public String getEtat() {

		return etat;

	}



	public void setEtat(String etat) {

		this.etat = etat;

	}



	public Map<String, String> getEtats() {

		return etats;

	}



	public void setEtats(Map<String, String> etats) {

		this.etats = etats;

	}



	public String getType() {

		return type;

	}



	public void setType(String type) {

		this.type = type;

	}



	public Map<String, String> getTypes() {

		return types;

	}



	public void setTypes(Map<String, String> types) {

		this.types = types;

	}



	public String getImmatriculation() {

		return immatriculation;

	}



	public void setImmatriculation(String immatriculation) {

		this.immatriculation = immatriculation;

	}



	public Double getKilometrage() {

		return kilometrage;

	}



	public void setKilometrage(Double kilometrage) {

		this.kilometrage = kilometrage;

	}



	public Double getPrix() {

		return prix;

	}



	public void setPrix(Double prix) {

		this.prix = prix;

	}



	public Long getIdVoiture() {

		return idVoiture;

	}



	public void setIdVoiture(Long idVoiture) {

		this.idVoiture = idVoiture;

	}



	public Entretien getEntretien() {

		return entretien;

	}



	public void setEntretien(Entretien entretien) {

		this.entretien = entretien;

	}



	public List<Entretien> getListeEt() {

		return listeEt;

	}



	public void setListeEt(List<Entretien> listeEt) {

		this.listeEt = listeEt;

	}



	public Vidange getVidange() {

		return vidange;

	}



	public void setVidange(Vidange vidange) {

		this.vidange = vidange;

	}



	public Logger getLog() {

		return log;

	}



	public void setLog(Logger log) {

		this.log = log;

	}



	public FiltreHuile getFiltreHuile() {

		return filtreHuile;

	}



	public void setFiltreHuile(FiltreHuile filtreHuile) {

		this.filtreHuile = filtreHuile;

	}



	public ChaineDistribution getChaineDist() {

		return chaineDist;

	}



	public void setChaineDist(ChaineDistribution chaineDist) {

		this.chaineDist = chaineDist;

	}

}