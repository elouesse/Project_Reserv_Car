package com.adaming.myapp.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.adaming.myapp.entities.Voiture;
import com.adaming.myapp.service.IVoitureService;

/*
 * @ErikDuhem
 * 10 08 2016
 * v1
 */

@Component("AddVoitureBean")
@RequestScoped
public class AddVoitureBean {
	
	@Autowired
	private IVoitureService serviceVoiture;
	
	private List<Voiture> voitures = new ArrayList<Voiture>();
	private Voiture voiture;
	
	private String carburant;  
	private Map<String,String> carburants = new HashMap<String, String>();
	
	@PostConstruct
	public void init() {
		voitures = serviceVoiture.getVoitures();
		
		carburants = new HashMap<String, String>();
		carburants.put("Essence 95", "Essence 95");
		carburants.put("Super 98 e10","Super 98 e10");
		carburants.put("Diesel", "Diesel");
		carburants.put("GPL","GPL");
	}

	public String getCarburant() {
		return carburant;
	}

	public void setCarburant(String carburant) {
		this.carburant = carburant;
	}

}
