package com.adaming.myapp.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.adaming.myapp.entities.Facture;
import com.adaming.myapp.entities.Reservation;
import com.adaming.myapp.service.IClientService;
import com.adaming.myapp.service.IFactureService;
import com.adaming.myapp.service.IReservationService;

@Component("ListFactureBean")
@RequestScoped
public class FactureBean {

	
	
	
	@Autowired
	private IFactureService service;
	@Autowired
	private IClientService serviceC;
	@Autowired
	private IReservationService serviceR;
	
	private List<Facture> factures;
	private Long idFacture;
	private Long idClient;
	private Long idReservation;
	private Long idVoiture;
	private Facture facture;
	private Reservation reservation;
	private double prix;
	private List<Facture> tab2;
	
	
	
	
	
	public List<Facture> getTab2() {
		return tab2;
	}


	public void setTab2(List<Facture> tab2) {
		this.tab2 = tab2;
	}


	public double getPrix() {
		return prix;
	}


	public void setPrix(double prix) {
		this.prix = prix;
	}


	public Long getIdFacture() {
		return idFacture;
	}


	public void setIdFacture(Long idFacture) {
		this.idFacture = idFacture;
	}


	public Long getIdClient() {
		return idClient;
	}


	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}


	public Long getIdReservation() {
		return idReservation;
	}


	public void setIdReservation(Long idReservation) {
		this.idReservation = idReservation;
	}


	public Long getIdVoiture() {
		return idVoiture;
	}


	public void setIdVoiture(Long idVoiture) {
		this.idVoiture = idVoiture;
	}


	public Facture getFacture() {
		return facture;
	}


	public void setFacture(Facture facture) {
		this.facture = facture;
	}


	public Reservation getReservation() {
		return reservation;
	}


	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}


	public List<Facture> getFactures() {
		return factures;
	}


	public void setFactures(List<Facture> factures) {
		this.factures = factures;
	}


	public FactureBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	@PostConstruct
	public void getFacts(){	
		factures = service.getFactures();
		tab2 = service.getFactures();
	}
	public void getInfoFact(){
		facture = service.getFactureById(idFacture);
		prix = service.coutFacture(idFacture);
		getFacts();
	}
	
}
