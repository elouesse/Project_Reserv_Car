package com.adaming.myapp.bean;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.adaming.myapp.Exception.ExceptionDispoVoiture;
import com.adaming.myapp.entities.Client;
import com.adaming.myapp.entities.Reservation;
import com.adaming.myapp.entities.Voiture;
import com.adaming.myapp.service.IClientService;
import com.adaming.myapp.service.IReservationService;
import com.adaming.myapp.service.IVoitureService;

@Component("addReservation")
@SessionScoped
public class AddReservationBean {

	@Autowired
	private IReservationService serviceReservation;
	@Autowired
	private IVoitureService serviceVoiture;
	@Autowired
	private IClientService serviceClient;

	public AddReservationBean() {
	}

	// Reservation Attributes
	private double prix;
	private Date dateDeReservation;
	private Date dateDeRentrer;
	private Date dateDeSortie;
	private String heureDeSortie;
	private String heureDeRentrer;
	private String etatDeReservation;
	private Integer nombresDeJours;

	// Voiture Attributes
	private Long idvoiture;
	private String model;
	private String immatricule;
	private Double kilometrage;
	private double prixV;
	private String typeVoiture;
	private String typeCarburant;
	private String etatVoiture;

	//Client Attributes
	private Long idClient;

	private Voiture selectedCar;
	private Voiture rentedCar;
	private Client customer;

	private List<Voiture> tabV;
	private List<Client> tabC;
	
	@PostConstruct
    public void init() {
		tabC= serviceClient.getClients();
	}
	
	public void getClient() {
		customer= serviceClient.getClient(idClient);
	}

	public void reservPeriod() throws ExceptionDispoVoiture {
		heureDeSortie = Integer.toString(dateDeSortie.getHours());
		heureDeRentrer = Integer.toString(dateDeRentrer.getHours());
		DateTime d1=new DateTime(dateDeSortie);
		DateTime d2=new DateTime(dateDeRentrer);
		nombresDeJours=Days.daysBetween(d1.toLocalDate(),d2.toLocalDate()).getDays();
		dateDeReservation = new Date();
		etatDeReservation = "Nouvel Reservation";
		tabV = serviceVoiture.getVoituresDispByPeriod(dateDeSortie,
				dateDeRentrer);
	}

	public void addReserv() {
		prix = nombresDeJours*rentedCar.getPrix();
		Reservation r = new Reservation(prix, dateDeReservation, dateDeRentrer, dateDeSortie, heureDeSortie, nombresDeJours,
				etatDeReservation,heureDeRentrer);
		serviceReservation.addReservation(r, idClient, rentedCar.getIdvoiture());
	}
	
	
	public void buttonAction(ActionEvent actionEvent) {
        addMessage("Votre Reservation a ete enregistre!!");
    }
     
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

	// Getters and Setters
	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Date getDateDeReservation() {
		return dateDeReservation;
	}

	public Date getDateDeRentrer() {
		return dateDeRentrer;
	}

	public void setDateDeRentrer(Date dateDeRentrer) {
		this.dateDeRentrer = dateDeRentrer;
	}

	public Date getDateDeSortie() {
		return dateDeSortie;
	}

	public void setDateDeSortie(Date dateDeSortie) {
		this.dateDeSortie = dateDeSortie;
	}

	public String getHeureDeSortie() {
		return heureDeSortie;
	}

	public void setHeureDeSortie(String heureDeSortie) {
		this.heureDeSortie = heureDeSortie;
	}

	public String getHeureDeRentrer() {
		return heureDeRentrer;
	}

	public void setHeureDeRentrer(String heureDeRentrer) {
		this.heureDeRentrer = heureDeRentrer;
	}

	public String getEtatDeReservation() {
		return etatDeReservation;
	}

	public void setEtatDeReservation(String etatDeReservation) {
		this.etatDeReservation = etatDeReservation;
	}

	public List<Voiture> getTabV() {
		return tabV;
	}

	public void setTabV(List<Voiture> tabV) {
		this.tabV = tabV;
	}

	public List<Client> getTabC() {
		return tabC;
	}

	public void setTabC(List<Client> tabC) {
		this.tabC = tabC;
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

	public double getPrixV() {
		return prixV;
	}

	public void setPrixV(double prixV) {
		this.prixV = prixV;
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

	public Voiture getSelectedCar() {
		return selectedCar;
	}

	public void setSelectedCar(Voiture selectedCar) {
		this.selectedCar = selectedCar;
	}

	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	public Integer getNombresDeJours() {
		return nombresDeJours;
	}

	public void setNombresDeJours(Integer nombresDeJours) {
		this.nombresDeJours = nombresDeJours;
	}

	public void setDateDeReservation(Date dateDeReservation) {
		this.dateDeReservation = dateDeReservation;
	}

	public Client getCustomer() {
		return customer;
	}

	public void setCustomer(Client customer) {
		this.customer = customer;
	}

	public Voiture getRentedCar() {
		return rentedCar;
	}

	public void setRentedCar(Voiture rentedCar) {
		this.rentedCar = rentedCar;
	}

}
