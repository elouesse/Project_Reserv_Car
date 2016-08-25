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
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.adaming.myapp.entities.Client;
import com.adaming.myapp.entities.Facture;
import com.adaming.myapp.entities.Reservation;
import com.adaming.myapp.entities.Voiture;
import com.adaming.myapp.service.IClientService;
import com.adaming.myapp.service.IFactureService;
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
	@Autowired
	private IFactureService serviceFacture;

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
	
	
	private Date dateInit;
	private Date dateInit2;
	private Voiture selectedCar;
	private Voiture rentedCar;
	private Voiture voiture;
	private Client customer;
	
	private Reservation reserv;
	private List<Reservation> tabR;

	private List<Voiture> tabV;
	private List<Client> tabC;
	
	
	@PostConstruct
    public void init() {
		tabC= serviceClient.getClients();
		tabR= serviceReservation.getHistorique();
		dateInit = new Date();
		dateInit2=dateInit;
	}
	
	public void chooseDate() {
		dateInit2=dateDeSortie;
//		if(dateDeRentrer.before(dateInit2))
			dateDeRentrer = dateInit2;
	}
	
	public void getClient() {
		customer= serviceClient.getClient(idClient);
	}

	public void reservPeriod() throws Exception {
		if(dateDeRentrer.before(dateDeSortie))
			throw new Exception("Cette date de retour n'est pas possible");
		else
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
		Reservation r = new Reservation(prix, dateDeReservation, dateDeRentrer, dateDeSortie, heureDeSortie, heureDeRentrer,
				etatDeReservation,nombresDeJours);
		serviceReservation.addReservation(r, idClient, rentedCar.getIdvoiture());
		serviceFacture.addFacture(1l, r.getIdreservation(), new Facture(dateDeReservation));
		this.tabV = null;
		this.dateDeRentrer = null;
		this.dateDeSortie = null;
		init();
	}
	
	public void onRowEdit(RowEditEvent event) {
		reserv = (Reservation) event.getObject();
		reserv.setHeureDeSortie(Integer.toString(reserv.getDateDeSortie().getHours()));
		reserv.setHeureDeRentrer(Integer.toString(reserv.getDateDeRentrer().getHours()));
		DateTime d1 = new DateTime(reserv.getDateDeSortie());
		DateTime d2 = new DateTime(reserv.getDateDeRentrer());
		nombresDeJours = Days.daysBetween(d1.toLocalDate(), d2.toLocalDate()).getDays();
		reserv.setNombresDeJours(nombresDeJours);
		reserv.setEtatDeReservation("Modifie");
		reserv.setPrix(reserv.getVoiture().getPrix()*reserv.getNombresDeJours());
		serviceReservation.updateReservation(reserv);
        FacesMessage msg = new FacesMessage("Reservation "+reserv.getIdreservation()+" Edited");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
	
	public void reset() {
		this.tabV = null;
		this.dateDeRentrer = null;
		this.dateDeSortie = null;
		this.dateDeReservation = null;
        RequestContext.getCurrentInstance().reset("forme:panel");
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

	public Date getDateInit() {
		return dateInit;
	}

	public void setDateInit(Date dateInit) {
		this.dateInit = dateInit;
	}

	public Date getDateInit2() {
		return dateInit2;
	}

	public void setDateInit2(Date dateInit2) {
		this.dateInit2 = dateInit2;
	}

	public Voiture getVoiture() {
		return voiture;
	}

	public void setVoiture(Voiture voiture) {
		this.voiture = voiture;
	}

	public Reservation getReserv() {
		return reserv;
	}

	public void setReserv(Reservation reserv) {
		this.reserv = reserv;
	}

	public List<Reservation> getTabR() {
		return tabR;
	}

	public void setTabR(List<Reservation> tabR) {
		this.tabR = tabR;
	}

}
