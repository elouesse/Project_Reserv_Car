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
	private Date   dateDeNaissance; 
	private String numeroTel; 
	private String numeroPermis; 
	private String adressPostal; 
	private String mail; 
	private String pays; 
	private Date   dateDeDelivrance;
	private String lieuDeNaissance;
	private String delivrerPar;	
	
	private Long idClientU;
	private String nomU;
	private String prenomU; 
	private Date   dateDeNaissanceU; 
	private String numeroTelU; 
	private String numeroPermisU; 
	private String adressPostalU; 
	private String mailU; 
	private String paysU; 
	private Date   dateDeDelivranceU;
	private String lieuDeNaissanceU;
	private String delivrerParU;	
	
	private List<Client> clients;
	
	private Client cli;
	
	private Client cliU;
	


	@PostConstruct
	public void getClient(){
		clients = serviceClient.getClients();
	}
	
	public void addClient(){
		Client c = new Client(nom, prenom, dateDeNaissance, numeroTel, numeroPermis, adressPostal, mail, pays, dateDeDelivrance, lieuDeNaissance, delivrerPar);
		serviceClient.addClient(c);
		getClient();	
	}
	
	public void getClie(){
		cli = serviceClient.getClient(idClient);
		System.out.println(cli);
		System.out.println(cli.getNom());
	}
	
	public void getClieU(){
		cliU = serviceClient.getClient(idClientU);
		nomU = cliU.getNom();
		prenomU = cliU.getPrenom();
		dateDeNaissanceU = cliU.getDateDeNaissance(); 
		numeroTelU =cliU.getNumeroTel(); 
		numeroPermisU = cliU.getNumeroPermis(); 
		adressPostalU = cliU.getAdressPostal(); 
		mailU = cliU.getMail(); 
		paysU = cliU.getPays(); 
		dateDeDelivranceU = cliU.getDateDeDelivrance();
		lieuDeNaissanceU = cliU.getLieuDeNaissance();
		delivrerParU = cliU.getDelivrerPar();
		
		System.out.println(cliU);
		System.out.println(cliU.getNom());
	}
	
	public void update(){
		System.out.println(idClientU);
		cliU = new Client(nomU, prenomU, dateDeNaissanceU, numeroTelU, numeroPermisU, adressPostalU, mailU, paysU, dateDeDelivranceU, lieuDeNaissanceU, delivrerParU);
		cliU.setIdClient(idClientU);
		serviceClient.updateClient(cliU);
		getClient();
	}
	


	public Long getIdClientU() {
		return idClientU;
	}

	public void setIdClientU(Long idClientU) {
		this.idClientU = idClientU;
	}

	public String getNomU() {
		return nomU;
	}

	public void setNomU(String nomU) {
		this.nomU = nomU;
	}

	public String getPrenomU() {
		return prenomU;
	}

	public void setPrenomU(String prenomU) {
		this.prenomU = prenomU;
	}

	public Date getDateDeNaissanceU() {
		return dateDeNaissanceU;
	}

	public void setDateDeNaissanceU(Date dateDeNaissanceU) {
		this.dateDeNaissanceU = dateDeNaissanceU;
	}

	public String getNumeroTelU() {
		return numeroTelU;
	}

	public void setNumeroTelU(String numeroTelU) {
		this.numeroTelU = numeroTelU;
	}

	public String getNumeroPermisU() {
		return numeroPermisU;
	}

	public void setNumeroPermisU(String numeroPermisU) {
		this.numeroPermisU = numeroPermisU;
	}

	public String getAdressPostalU() {
		return adressPostalU;
	}

	public void setAdressPostalU(String adressPostalU) {
		this.adressPostalU = adressPostalU;
	}

	public String getMailU() {
		return mailU;
	}

	public void setMailU(String mailU) {
		this.mailU = mailU;
	}

	public String getPaysU() {
		return paysU;
	}

	public void setPaysU(String paysU) {
		this.paysU = paysU;
	}

	public Date getDateDeDelivranceU() {
		return dateDeDelivranceU;
	}

	public void setDateDeDelivranceU(Date dateDeDelivranceU) {
		this.dateDeDelivranceU = dateDeDelivranceU;
	}

	public String getLieuDeNaissanceU() {
		return lieuDeNaissanceU;
	}

	public void setLieuDeNaissanceU(String lieuDeNaissanceU) {
		this.lieuDeNaissanceU = lieuDeNaissanceU;
	}

	public String getDelivrerParU() {
		return delivrerParU;
	}

	public void setDelivrerParU(String delivrerParU) {
		this.delivrerParU = delivrerParU;
	}

	public void destroyWorld() {
        addMessage("Succ�s!", "Le client a bien �t� ajout�");
    }
     
    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
	

    public Client getCliU() {
		return cliU;
	}

	public void setCliU(Client cliU) {
		this.cliU = cliU;
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
