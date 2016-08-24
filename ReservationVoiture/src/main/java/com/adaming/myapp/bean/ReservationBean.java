package com.adaming.myapp.bean;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.adaming.myapp.entities.*;
import com.adaming.myapp.service.IClientService;
import com.adaming.myapp.service.IReservationService;
import com.adaming.myapp.service.IVoitureService;

@Component("ReservationBean")
@RequestScoped
public class ReservationBean {

	@Autowired
	private IReservationService serviceReservation;
	@Autowired
	private IVoitureService serviceVoiture;
	@Autowired
	private IClientService serviceClient;

	// Reservation Attributes
	private double prix;
	private Date dateDeReservation;
	private Date dateDeRentrer;
	private Date dateDeSortie;
	private String heureDeSortie;
	private String heureDeRentrer;
	private String etatDeReservation;
	private Integer nombresDeJours;

	// Voiture
	private Voiture voiture;
	// Client
	private Client client;
	// Facture
	private Facture facture;

	private Reservation reserv;
	private List<Reservation> tabR;
	
	public ReservationBean() {
	}
	
	public List<Reservation> getTabR() {
		return tabR;
	}
	
	@PostConstruct
    public void init() {
		tabR= serviceReservation.getHistorique();
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

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Date getDateDeReservation() {
		return dateDeReservation;
	}

	public void setDateDeReservation(Date dateDeReservation) {
		this.dateDeReservation = dateDeReservation;
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

	public Integer getNombresDeJours() {
		return nombresDeJours;
	}

	public void setNombresDeJours(Integer nombresDeJours) {
		this.nombresDeJours = nombresDeJours;
	}

	public Voiture getVoiture() {
		return voiture;
	}

	public void setVoiture(Voiture voiture) {
		this.voiture = voiture;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Facture getFacture() {
		return facture;
	}

	public void setFacture(Facture facture) {
		this.facture = facture;
	}

	public Reservation getReserv() {
		return reserv;
	}

	public void setReserv(Reservation reserv) {
		this.reserv = reserv;
	}

}
