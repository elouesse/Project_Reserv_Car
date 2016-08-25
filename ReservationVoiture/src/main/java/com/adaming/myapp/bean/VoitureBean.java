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
	private Long idEntretien;
	private Entretien entretien;
	private String model;
	private String immatricule;
	private Double kilometrage;
	private double prix;
	private double preference;
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
	private Boolean cok1 = false;
	private Boolean cok2 = false;
	private Boolean cok3 = false;
	private Date dateEntretienInit;
	private Boolean creaOk;
	private Date dateEntretienValue1;
	private Date dateEntretienValue2;
	private Date dateEntretienValue3;
	private int prixEnt1;
	private int prixEnt2;
	private int prixEnt3;
	private Double kilometrageEnt1;
	private Double kilometrageEnt2;
	private Double kilometrageEnt3;

	/*
	 * 
	 * METHODES
	 * 
	 */

	@PostConstruct
	public void init() {
		refreshListe();
		setDateEntretienInit(new Date());

		carburants = new HashMap<String, String>();
		carburants.put("Essence 95", "Essence 95");
		carburants.put("Super 98 e10", "Super 98 e10");
		carburants.put("Diesel", "Diesel");
		carburants.put("GPL", "GPL");

		modeles = new HashMap<String, String>();
		modeles.put("Renault", "Renault");
		modeles.put("Mercedes", "Mercedes");
		modeles.put("Alfa Romeo", "Alfa Romeo");
		modeles.put("Bugatti", "Bugatti");
		modeles.put("Chevrolet", "Chevrolet");
		modeles.put("Dodge", "Dodge");
		modeles.put("Porsche", "Porsche");
		modeles.put("Rolce Royce", "Rolce Royce");
		modeles.put("Audi", "Audi");
		modeles.put("Cadillac", "Cadillac");
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

	public String redirectListeVoiture() {
		voiture = null;
		voitureSelect = null;
		remiseAZero();
		return "listeVoiture?faces-redirect=true";
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
		return "updateVoiture?faces-redirect=true";
	}

	public String goToCompteur() {
		return "updateCompteur?faces-redirect=true";
	}

	public void addVoiture() {
		setVoiture(serviceVoiture
				.addVoiture(new Voiture(modele, immatriculation, kilometrage, prix, type, carburant, etat)));
		setIdVoiture(voiture.getIdvoiture());
		addEntretient(idVoiture);
		refreshListe();
		setCreaOk(true);
	}

	public void addEntretient(Long idV) {
		setVidange(new Vidange(new Date(), kilometrage + 10000., 80));
		setFiltreHuile(new FiltreHuile(new Date(), kilometrage + 30000., 150));
		setChaineDist(new ChaineDistribution(new Date(), kilometrage + 70000., 600));
		serviceEntretien.addEntretien(getVidange(), idV);
		serviceEntretien.addEntretien(getFiltreHuile(), idV);
		serviceEntretien.addEntretien(getChaineDist(), idV);
	}
	
	public void updateEntretien() {
		
		// vidange
		if (cok1 == true) {
			Long Id1 = entretiens.get(0).getIdEntretient();
			Entretien ent1 = serviceEntretien.getEntretienById(Id1);
			ent1.setDateEntretient(dateEntretienValue1);
			ent1.setKilometrage(kilometrageEnt1);
			ent1.setPrixEntrtient(prixEnt1);
			serviceEntretien.updateEntretien(ent1);
		}
		// filtre a huile
		if (cok2 == true) {
			Long Id2 = entretiens.get(1).getIdEntretient();
			Entretien ent2 = serviceEntretien.getEntretienById(Id2);
			ent2.setDateEntretient(dateEntretienValue2);
			ent2.setKilometrage(kilometrageEnt2);
			ent2.setPrixEntrtient(prixEnt2);
			serviceEntretien.updateEntretien(ent2);
		}
		// chaine de distribution
		if (cok3 == true) {
			Long Id3 = entretiens.get(2).getIdEntretient();
			Entretien ent3 = serviceEntretien.getEntretienById(Id3);
			ent3.setDateEntretient(dateEntretienValue3);
			ent3.setKilometrage(kilometrageEnt3);
			ent3.setPrixEntrtient(prixEnt3);
			serviceEntretien.updateEntretien(ent3);
		}
		
	}

	public void updateVoiture() {
		if (carburant != null) {
			voitureSelect.setTypeCarburant(carburant);
		}
		if (modele != null) {
			voitureSelect.setModel(modele);
		}
		if (etat != null) {
			voitureSelect.setEtatVoiture(etat);
		}
		if (type != null) {
			voitureSelect.setTypeVoiture(type);
		}
		if (!immatriculation.isEmpty()) {
			voitureSelect.setImmatricule(immatriculation);
		}
		if (kilometrage != 0.) {
			voitureSelect.setKilometrage(kilometrage);
		}
		if (prix != 0.) {
			voitureSelect.setPrix(prix);
		}

		serviceVoiture.updateVoiture(voitureSelect);
		refreshListe();
		remiseAZero();
		setCreaOk(false);
	}

	public void updateCompteur() {
		voitureSelect.setKilometrage(kilometrage);
		serviceVoiture.updateVoiture(voitureSelect);
		entretiens = serviceEntretien.getEntretiensOfOneCar(voitureSelect.getIdvoiture());
		Iterator<Entretien> tabE = entretiens.iterator();
		while (tabE.hasNext()) {
			entretien = tabE.next();
			switch (entretien.getClass().getSimpleName()) {
			case "Vidange":
				cok1 = serviceVoiture.alertEntretien(voitureSelect.getIdvoiture(), entretien.getIdEntretient(), 10000.);
				if (cok1 = true) {
					alertEntretien("Alerte", "Cette voiture a besoin d'une vidange.");
				}
				break;

			case "FiltreHuile":
				System.out.println("FH");
				cok2 = serviceVoiture.alertEntretien(voitureSelect.getIdvoiture(), entretien.getIdEntretient(), 30000.);
				if (cok2 = true) {
					alertEntretien("Alerte", "Cette voiture a besoin d'un changement de son filtre a huile.");
				}
				break;

			case "ChaineDistribution":
				System.out.println("CD");
				cok3 = serviceVoiture.alertEntretien(voitureSelect.getIdvoiture(), entretien.getIdEntretient(), 70000.);
				if (cok3 = true) {
					alertEntretien("Alerte", "Cette voiture a besoin d'un entretien de la chaine de distribution.");
				}
				break;

			default:
				break;
			}
		}
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

	public void alertEntretien(String msg, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, msg, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void remiseAZero() {
		setCarburant(null);
		setEtat(null);
		setImmatriculation(null);
		setKilometrage(0.);
		setPrix(0.);
		setType(null);
		setModele(null);
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

	public IEntretienService getServiceEntretien() {
		return serviceEntretien;
	}

	public void setServiceEntretien(IEntretienService serviceEntretien) {
		this.serviceEntretien = serviceEntretien;
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

	public List<Entretien> getEntretiens() {
		return entretiens;
	}

	public void setEntretiens(List<Entretien> entretiens) {
		this.entretiens = entretiens;
	}

	public Long getIdEntretien() {
		return idEntretien;
	}

	public void setIdEntretien(Long idEntretien) {
		this.idEntretien = idEntretien;
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

	public double getPreference() {
		return preference;
	}

	public void setPreference(double preference) {
		this.preference = preference;
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

	public void setEntretien(Entretien entretien) {
		this.entretien = entretien;
	}

	public Boolean getCok1() {
		return cok1;
	}

	public void setCok1(Boolean cok1) {
		this.cok1 = cok1;
	}

	public Boolean getCok2() {
		return cok2;
	}

	public void setCok2(Boolean cok2) {
		this.cok2 = cok2;
	}

	public Boolean getCok3() {
		return cok3;
	}

	public void setCok3(Boolean cok3) {
		this.cok3 = cok3;
	}

	public Date getDateEntretienInit() {
		return dateEntretienInit;
	}

	public void setDateEntretienInit(Date dateEntretienInit) {
		this.dateEntretienInit = dateEntretienInit;
	}

	public Boolean getCreaOk() {
		return creaOk;
	}

	public void setCreaOk(Boolean creaOk) {
		this.creaOk = creaOk;
	}

	public Date getDateEntretienValue1() {
		return dateEntretienValue1;
	}

	public void setDateEntretienValue1(Date dateEntretienValue1) {
		this.dateEntretienValue1 = dateEntretienValue1;
	}

	public Date getDateEntretienValue2() {
		return dateEntretienValue2;
	}

	public void setDateEntretienValue2(Date dateEntretienValue2) {
		this.dateEntretienValue2 = dateEntretienValue2;
	}

	public Date getDateEntretienValue3() {
		return dateEntretienValue3;
	}

	public void setDateEntretienValue3(Date dateEntretienValue3) {
		this.dateEntretienValue3 = dateEntretienValue3;
	}

	public int getPrixEnt1() {
		return prixEnt1;
	}

	public void setPrixEnt1(int prixEnt1) {
		this.prixEnt1 = prixEnt1;
	}

	public int getPrixEnt2() {
		return prixEnt2;
	}

	public void setPrixEnt2(int prixEnt2) {
		this.prixEnt2 = prixEnt2;
	}

	public int getPrixEnt3() {
		return prixEnt3;
	}

	public void setPrixEnt3(int prixEnt3) {
		this.prixEnt3 = prixEnt3;
	}

	public Double getKilometrageEnt1() {
		return kilometrageEnt1;
	}

	public void setKilometrageEnt1(Double kilometrageEnt1) {
		this.kilometrageEnt1 = kilometrageEnt1;
	}

	public Double getKilometrageEnt2() {
		return kilometrageEnt2;
	}

	public void setKilometrageEnt2(Double kilometrageEnt2) {
		this.kilometrageEnt2 = kilometrageEnt2;
	}

	public Double getKilometrageEnt3() {
		return kilometrageEnt3;
	}

	public void setKilometrageEnt3(Double kilometrageEnt3) {
		this.kilometrageEnt3 = kilometrageEnt3;
	}

}