package com.adaming.myapp.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.adaming.myapp.entities.ChaineDistribution;
import com.adaming.myapp.entities.Entretien;
import com.adaming.myapp.entities.FiltreHuile;
import com.adaming.myapp.entities.Vidange;
import com.adaming.myapp.entities.Voiture;
import com.adaming.myapp.service.IEntretienService;
import com.adaming.myapp.service.IVoitureService;

/*
 * @ERIK DUHEM
 * 09 08 2016
 * V2
 */

@Component("VoitureBean")
@RequestScoped
public class VoitureBean {

	/*
	 * 
	 * ATTRIBUTS
	 * 
	 */

	@Autowired
	private IVoitureService serviceVoiture;

	@Autowired
	private IEntretienService serviceEntretien;

	private List<Voiture> voitures = new ArrayList<Voiture>();
	private Voiture voiture;
	private List<Entretien> entretiens = new ArrayList<Entretien>();
	private Entretien entretien;
	private String model;
	private String immatricule;
	private Double kilometrage;
	private double prix;
	private String typeVoiture;
	private String typeCarburant;
	private String etatVoiture;
	private Voiture voitureSelect;
	private String carburant;
	private Long idVoiture;
	private List<Voiture> voituresFilter = new ArrayList<Voiture>();

	private Map<String, String> carburants = new HashMap<String, String>();
	private String modele;
	private Map<String, String> modeles = new HashMap<String, String>();
	private String etat;
	private Map<String, String> etats = new HashMap<String, String>();
	private String type;
	private Map<String, String> types = new HashMap<String, String>();
	private Vidange vidange;
	private FiltreHuile filtreHuile;
	private ChaineDistribution chaineDist;
	private String immatriculation;

	/*
	 * 
	 * METHODES
	 * 
	 */

	@PostConstruct
	public void init() {
		refreshListe();

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

	public void refreshListe() {
		voituresFilter = serviceVoiture.getVoitures();
		voitures = serviceVoiture.getVoitures();

	}

	public void getEntretien() {
		entretiens = serviceEntretien.getEntretiensOfOneCar(idVoiture);
		for (Entretien e : entretiens) {
			e.setTypeEntretient(e.getClass().getSimpleName());
		}
	}

	public void getInfoVoiture() {
		System.out.println("===== getinfovoiture " + idVoiture + " =====");
		voiture = serviceVoiture.getVoiture(idVoiture);
	}

	public void deleteVoiture() {
		entretiens = serviceEntretien.getEntretiensOfOneCar(idVoiture);
		Iterator<Entretien> iteEnt = entretiens.iterator();
		while (iteEnt.hasNext()) {
			serviceEntretien.deleteEntretien(iteEnt.next().getIdEntretient());
		}
		System.out.println("id voiture :" + idVoiture);
		voiture = serviceVoiture.deleteVoiture(idVoiture);
		confirmationDelete();
		refreshListe();
	}

	public String goToUpdateVoiture() {
		return "updateVoiture?redirect=true";
	}
	
	public String goToCompteur() {
		return "updateCompteur?redirect=true";
	}

	public void addEntretient(Long idV) {
		setVidange(new Vidange(new Date(), kilometrage + 10000., 80));
		setFiltreHuile(new FiltreHuile(new Date(), kilometrage + 30000., 150));
		setChaineDist(new ChaineDistribution(new Date(), kilometrage + 70000., 600));
		serviceEntretien.addEntretien(getVidange(), idV);
		serviceEntretien.addEntretien(getFiltreHuile(), idV);
		serviceEntretien.addEntretien(getChaineDist(), idV);
	}

	public void addVoiture() {
		Voiture vtr = new Voiture(modele, immatriculation, kilometrage, prix, type, carburant, etat);
		setVoiture(serviceVoiture.addVoiture(vtr));
		setIdVoiture(voiture.getIdvoiture());
		addEntretient(idVoiture);
		refreshListe();
	}
	
	public void updateVoiture () {
		System.out.println("Id : "+voitureSelect.getIdvoiture());
		System.out.println("carburant : "+carburant);
		if (carburant != null) { voitureSelect.setTypeCarburant(carburant); }
		if (modele != null)	{ voitureSelect.setModel(modele);	}
		if (etat != null){ voitureSelect.setEtatVoiture(etat); }
		if (type != null) { voitureSelect.setTypeVoiture(type); }
		if (immatriculation != null) { voitureSelect.setImmatricule(immatriculation);	}
		if (kilometrage != 0.) { voitureSelect.setKilometrage(kilometrage); }
		if (prix != 0.) { voitureSelect.setPrix(prix); }
		
		serviceVoiture.updateVoiture(voitureSelect);
		refreshListe();
	}
	
	public void confirmationDelete() {
		messageDelete("Succes", "La voiture a bien été supprimee");
	}

	public void confirmationAdd() {
		messageAdd("Succes", "La voiture a bien été crée");
	}

	public void confirmationUpdate() {
		messageUpdate("Success", "La voiture a bien été mis a jour");
	}

	public void messageDelete(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_FATAL, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	public void messageAdd(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	public void messageUpdate(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	/*
	 * 
	 * CONSTRUCTEURS
	 * 
	 */

	public VoitureBean() {
		super();
	}

	/*
	 * 
	 * ACCESSEURS
	 * 
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

	public Voiture getVoitureSelect() {
		return voitureSelect;
	}

	public void setVoitureSelect(Voiture voitureSelect) {
		this.voitureSelect = voitureSelect;
	}

	public String getCarburant() {
		return carburant;
	}

	public void setCarburant(String carburant) {
		this.carburant = carburant;
	}

	public Long getIdVoiture() {
		return idVoiture;
	}

	public void setIdVoiture(Long idVoiture) {
		this.idVoiture = idVoiture;
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

	public Vidange getVidange() {
		return vidange;
	}

	public void setVidange(Vidange vidange) {
		this.vidange = vidange;
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

	public String getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	public List<Voiture> getVoituresFilter() {
		return voituresFilter;
	}

	public void setVoituresFilter(List<Voiture> voituresFilter) {
		this.voituresFilter = voituresFilter;
	}

	public Map<String, String> getCarburants() {
		return carburants;
	}

	public void setCarburants(Map<String, String> carburants) {
		this.carburants = carburants;
	}

}