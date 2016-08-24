package com.adaming.myapp.bean;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import com.adaming.myapp.entities.Client;
import com.adaming.myapp.service.IClientService;

@Component("ClientB")
@RequestScoped
public class ClientBean {

	@Autowired
	private IClientService serviceClient;

	private Long idClient;
	private String nom;
	private String prenom;
	private Date dateDeNaissance;
	private String numeroTel;
	private String numeroPermis;
	private String adressPostal;
	private String mail;
	private String pays;
	private Date dateDeDelivrance;
	private String lieuDeNaissance;
	private String delivrerPar;

	private List<Client> clients;
	private List<Client> clientsFiltre;

	private Client cli;

	@PostConstruct
	public void getClient() {
		clientsFiltre = serviceClient.getClients();
		clients = serviceClient.getClients();
		cli = serviceClient.getClient(1L);
	}

	public String addClient() {
		Client c = new Client(nom, prenom, dateDeNaissance, numeroTel, numeroPermis, adressPostal, mail, pays,
				dateDeDelivrance, lieuDeNaissance, delivrerPar);
		serviceClient.addClient(c);
		getClient();
		return "index?faces-redirect=true";
	}

	public void getClie() {
		cli = serviceClient.getClient(idClient);
		System.out.println(cli);
		System.out.println(cli.getNom());
	}

	public void update() {
		System.out.println(cli.getIdClient());
		cli = new Client(cli.getNom(), cli.getPrenom(), cli.getDateDeNaissance(), cli.getNumeroTel(),
				cli.getNumeroPermis(), cli.getAdressPostal(), cli.getMail(), cli.getPays(), cli.getDateDeDelivrance(),
				cli.getLieuDeNaissance(), cli.getDelivrerPar());
		cli.setIdClient(idClient);
		serviceClient.updateClient(cli);
		getClient();
	}

	public void destroyWorld() {
		addMessage("Succés!", "Le client a bien été ajouté");
	}

	public void destroyWorld2() {
		addMessage("Succés!", "Le client a bien été modifié");
	}

	public void addMessage(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public List<Client> getClientsFiltre() {
		return clientsFiltre;
	}

	public void setClientsFiltre(List<Client> clientsFiltre) {
		this.clientsFiltre = clientsFiltre;
	}

	public Client getCli() {
		return cli;
	}

	public void setCli(Client cli) {
		this.cli = cli;
	}

	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public String getNumeroTel() {
		return numeroTel;
	}

	public void setNumeroTel(String numeroTel) {
		this.numeroTel = numeroTel;
	}

	public String getNumeroPermis() {
		return numeroPermis;
	}

	public void setNumeroPermis(String numeroPermis) {
		this.numeroPermis = numeroPermis;
	}

	public String getAdressPostal() {
		return adressPostal;
	}

	public void setAdressPostal(String adressPostal) {
		this.adressPostal = adressPostal;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public Date getDateDeDelivrance() {
		return dateDeDelivrance;
	}

	public void setDateDeDelivrance(Date dateDeDelivrance) {
		this.dateDeDelivrance = dateDeDelivrance;
	}

	public String getLieuDeNaissance() {
		return lieuDeNaissance;
	}

	public void setLieuDeNaissance(String lieuDeNaissance) {
		this.lieuDeNaissance = lieuDeNaissance;
	}

	public String getDelivrerPar() {
		return delivrerPar;
	}

	public void setDelivrerPar(String delivrerPar) {
		this.delivrerPar = delivrerPar;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

}
