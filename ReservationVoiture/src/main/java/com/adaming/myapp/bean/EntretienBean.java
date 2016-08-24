package com.adaming.myapp.bean;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

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
	private Double kilommetrage;
	private Integer prixEntrtient;
	private Voiture voiture;
	private Entretien entretien;
	private Entretien selectEntretien;
	private List<Entretien> entretiens;
	private List<Entretien> fentretiens;

	private Long idVoiture;

	public String updateEntretien() {

		System.out.println("prix :" + selectEntretien.getPrixEntrtient());
		System.out.println("id :" + selectEntretien.getIdEntretient());

		service.updateEntretien(selectEntretien);
		entretiens = service.getEntretiens();
		for (Entretien e : entretiens) {
			e.setTypeEntretient(e.getClass().getSimpleName());
		}
		fentretiens = service.getEntretiens();
		for (Entretien e : fentretiens) {
			e.setTypeEntretient(e.getClass().getSimpleName());
		}
		return "entretien?faces-redirect=true";
	}

	public String goToUpdateEntretien() {
		return "updateEntretien?faces-redirect=true";
	}

	public void deleteEntr() {

		service.deleteEntretien(idEntretient);
		confirmationDelete();
		entretiens = service.getEntretiens();
		for (Entretien e : entretiens) {
			e.setTypeEntretient(e.getClass().getSimpleName());
		}
		fentretiens = service.getEntretiens();
		for (Entretien e : fentretiens) {
			e.setTypeEntretient(e.getClass().getSimpleName());
		}
	}

	public void confirmationUpdate() {
		messageUpdate("Success", "L'entretien a bien été mis a jour");
	}

	public void confirmationDelete() {
		messageDelete("Succes", "L'entretien a bien été supprimé");
	}

	public void messageDelete(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_FATAL,
				summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void messageUpdate(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	@PostConstruct
	public void getEntretens() {

		entretiens = service.getEntretiens();
		for (Entretien e : entretiens) {
			e.setTypeEntretient(e.getClass().getSimpleName());
		}
		fentretiens = service.getEntretiens();
		for (Entretien e : fentretiens) {
			e.setTypeEntretient(e.getClass().getSimpleName());
		}
	}

	public Long getIdVoiture() {
		return idVoiture;
	}

	public void setIdVoiture(Long idVoiture) {
		this.idVoiture = idVoiture;
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
		return kilommetrage;
	}

	public void setKilommetrage(Double kilommetrage) {
		this.kilommetrage = kilommetrage;
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

	public List<Entretien> getFentretiens() {
		return fentretiens;
	}

	public Entretien getEntretien() {
		return entretien;
	}

	public void setEntretien(Entretien entretien) {
		this.entretien = entretien;
	}

	public void setFentretiens(List<Entretien> fentretiens) {
		this.fentretiens = fentretiens;
	}

	public EntretienBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Entretien getSelectEntretien() {
		return selectEntretien;
	}

	public void setSelectEntretien(Entretien selectEntretien) {
		this.selectEntretien = selectEntretien;
	}

}