/**
 * 
 */
package com.adaming.myapp.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author Thomas Bernard
 *
 */
@Entity
public class Agence {

	
	//attribut
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idAgence;
    private String denomination;
    private String formJuridique;
    private String activite;
    private String adressSiege;
    
    //association
    @OneToMany(mappedBy="agence", fetch=FetchType.EAGER)
    private List<Facture> listFacture;

	public Agence(String denomination, String formJuridique, String activite,
			String adressSiege) {
		super();
		this.denomination = denomination;
		this.formJuridique = formJuridique;
		this.activite = activite;
		this.adressSiege = adressSiege;
	}

	public Agence() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getIdAgence() {
		return idAgence;
	}

	public void setIdAgence(Long idAgence) {
		this.idAgence = idAgence;
	}

	public String getDenomination() {
		return denomination;
	}

	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}

	public String getFormJuridique() {
		return formJuridique;
	}

	public void setFormJuridique(String formJuridique) {
		this.formJuridique = formJuridique;
	}

	public String getActivite() {
		return activite;
	}

	public void setActivite(String activite) {
		this.activite = activite;
	}

	public String getAdressSiege() {
		return adressSiege;
	}

	public void setAdressSiege(String adressSiege) {
		this.adressSiege = adressSiege;
	}

	public List<Facture> getListFacture() {
		return listFacture;
	}

	public void setListFacture(List<Facture> listFacture) {
		this.listFacture = listFacture;
	}
    
    
    
}
