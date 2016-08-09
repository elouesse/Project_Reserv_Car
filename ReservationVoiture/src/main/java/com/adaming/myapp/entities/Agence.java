/**
 * 
 */
package com.adaming.myapp.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
    @OneToMany
    @JoinTable(name="TableFactureAgence")
    private List<Facture> listFacture;
    
}
