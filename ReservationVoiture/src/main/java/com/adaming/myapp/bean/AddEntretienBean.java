package com.adaming.myapp.bean;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.adaming.myapp.entities.Entretien;
import com.adaming.myapp.entities.Voiture;
import com.adaming.myapp.service.IEntretienService;
import com.adaming.myapp.service.IVoitureService;

public class AddEntretienBean {

	@Autowired
	private IVoitureService serviceVoiture;
	@Autowired
	private IEntretienService serviceEntretien;
	
	private List<Voiture> listV;
	private List<Entretien> listE;
	private String typeEntretient;
	private  Double kilometrage;
	private Integer prixEntrtient;
	private Long idV;
	
	@PostConstruct
	public void getVoitures() {

		
		listV = serviceVoiture.getVoitures();
	}
	public void getEntretienByCar(){
		
		listE = serviceEntretien.getEntretiensOfOneCar(idV);
	}
	
	public AddEntretienBean() {
		super();
		// TODO Auto-generated constructor stub
	}


	public List<Entretien> getListE() {
		return listE;
	}


	public void setListE(List<Entretien> listE) {
		this.listE = listE;
	}


	public Long getIdV() {
		return idV;
	}
	public void setIdV(Long idV) {
		this.idV = idV;
	}
	public List<Voiture> getListV() {
		return listV;
	}


	public void setListV(List<Voiture> listV) {
		this.listV = listV;
	}


	public String getTypeEntretient() {
		return typeEntretient;
	}


	public void setTypeEntretient(String typeEntretient) {
		this.typeEntretient = typeEntretient;
	}


	public Double getKilometrage() {
		return kilometrage;
	}


	public void setKilometrage(Double kilometrage) {
		this.kilometrage = kilometrage;
	}


	public Integer getPrixEntrtient() {
		return prixEntrtient;
	}


	public void setPrixEntrtient(Integer prixEntrtient) {
		this.prixEntrtient = prixEntrtient;
	}
	
	
	
	
	
}
