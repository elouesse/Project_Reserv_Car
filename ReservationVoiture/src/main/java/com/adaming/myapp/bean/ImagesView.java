package com.adaming.myapp.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.RateEvent;
 
@ManagedBean
public class ImagesView {
     
    private List<String> images;
    
    private Integer rating3; 
    
   

	public void onrate(RateEvent rateEvent) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Note du site", "Vous avez noté:" + ((Integer) rateEvent.getRating()).intValue());
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
     
    public void oncancel() {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Note du site", "Note annulée");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
     
    @PostConstruct
    public void init() {
        images = new ArrayList<String>();
        for (int i = 1; i <= 12; i++) {
            images.add("car" + i + ".png");
        }
    }
 
    public List<String> getImages() {
        return images;
    }
    
    public Integer getRating3() {
		return rating3;
	}

	public void setRating3(Integer rating3) {
		this.rating3 = rating3;
	}
    
}
