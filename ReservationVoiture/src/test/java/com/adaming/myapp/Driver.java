package com.adaming.myapp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.adaming.myapp.Exception.ExceptionDispoVoiture;
import com.adaming.myapp.entities.Client;
import com.adaming.myapp.entities.Reservation;
import com.adaming.myapp.entities.Voiture;
import com.adaming.myapp.service.IClientService;
import com.adaming.myapp.service.IReservationService;
import com.adaming.myapp.service.IVoitureService;

public class Driver {

	public static void main(String[] args) throws ParseException, ExceptionDispoVoiture {
		ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("app.xml");
		IClientService c = (IClientService) context.getBean("ClientServiceImpl");
		IVoitureService v = (IVoitureService) context.getBean("VoitureServiceImpl");
		IReservationService r = (IReservationService) context.getBean("ReservationServiceImpl");
		SimpleDateFormat fr = new SimpleDateFormat("yyyy-MM-dd");
		
		System.out.println(v.getVoituresDispByPeriod(fr.parse("2016-05-02"), fr.parse("2016-05-02")));
		
		
//		v.addVoiture(new Voiture("xx", "SDEK", 300.0, 8000.0, "Q", "e", "QW"));
//		r.addReservation(new Reservation(300.0, new Date(), fr.parse("2106-05-02 09:55"), fr.parse("2109-05-02 09:55"), "324", "sf", 23, "ws"), 1l, 1l);

	}

}
