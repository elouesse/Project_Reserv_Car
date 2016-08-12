package com.adaming.myapp.bean;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.adaming.myapp.entities.Entretien;
import com.adaming.myapp.entities.Voiture;
import com.adaming.myapp.service.IEntretienService;

@Component("EntretienBean")
@RequestScoped
public class EntretienBean {

	@Autowired
	private IEntretienService service;
	
	private Long idEntretient;
	private String typeEntretient;
	private Date dateEntretient;
	private  Double Kilommetrage;
	private Integer prixEntrtient;
	private Voiture voiture;
	
	private List<Entretien> entretiens;
	
	
	@PostConstruct
	public void getEntretens(){
		
		entretiens = service.getEntretiens();
		for (Entretien e : entretiens){	
			e.setTypeEntretient(e.getClass().getSimpleName());	
		}	
	}
	
	public List<Entretien> getEntretiens() {
		return entretiens;
	}
	public void setEntretiens(List<Entretien> entretiens) {
		this.entretiens = entretiens;
	}
	public Long getIdEntretient() {
		return idEntretient;
	}
	public void setIdEntretient(Long idEntretient) {
		this.idEntretient = idEntretient;
	}
	public String getTypeEntretient() {
		return typeEntretient;
	}
	public void setTypeEntretient(String typeEntretient) {
		this.typeEntretient = typeEntretient;
	}
	public Date getDateEntretient() {
		return dateEntretient;
	}
	public void setDateEntretient(Date dateEntretient) {
		this.dateEntretient = dateEntretient;
	}
	public Double getKilommetrage() {
		return Kilommetrage;
	}
	public void setKilommetrage(Double kilommetrage) {
		Kilommetrage = kilommetrage;
	}
	public Integer getPrixEntrtient() {
		return prixEntrtient;
	}
	public void setPrixEntrtient(Integer prixEntrtient) {
		this.prixEntrtient = prixEntrtient;
	}
	public Voiture getVoiture() {
		return voiture;
	}
	public void setVoiture(Voiture voiture) {
		this.voiture = voiture;
	}
	public EntretienBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	
}
