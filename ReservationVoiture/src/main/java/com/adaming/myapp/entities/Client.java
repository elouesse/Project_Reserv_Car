/**
 * 
 */
package com.adaming.myapp.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author Eli
 *
 */
@Entity
public class Client {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idClient;
	private String nom;
	private String prenom; 
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date   dateDeNaissance; 
	private String numeroTel; 
	private String numeroPermis; 
	private String adressPostal; 
	private String mail; 
	private String pays; 
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date   dateDeDelivrance;
	private String lieuDeNaissance;
	private String delivrerPar;
	
	public Client(String nom, String prenom, Date dateDeNaissance,
			String numeroTel, String numeroPermis, String adressPostal,
			String mail, String pays, Date dateDeDelivrance,
			String lieuDeNaissance, String delivrerPar) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateDeNaissance = dateDeNaissance;
		this.numeroTel = numeroTel;
		this.numeroPermis = numeroPermis;
		this.adressPostal = adressPostal;
		this.mail = mail;
		this.pays = pays;
		this.dateDeDelivrance = dateDeDelivrance;
		this.lieuDeNaissance = lieuDeNaissance;
		this.delivrerPar = delivrerPar;
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
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}


}
