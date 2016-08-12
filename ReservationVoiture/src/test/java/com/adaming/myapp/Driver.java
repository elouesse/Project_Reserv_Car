package com.adaming.myapp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.adaming.myapp.Exception.ExceptionDispoVoiture;
import com.adaming.myapp.entities.Client;
import com.adaming.myapp.entities.Facture;
import com.adaming.myapp.entities.Reservation;
import com.adaming.myapp.entities.Voiture;
import com.adaming.myapp.service.IClientService;
import com.adaming.myapp.service.IFactureService;
import com.adaming.myapp.service.IReservationService;
import com.adaming.myapp.service.IVoitureService;

public class Driver {

	public static void main(String[] args) throws ParseException, ExceptionDispoVoiture {
		ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("app.xml");
		IClientService c = (IClientService) context.getBean("ClientServiceImpl");
		IVoitureService v = (IVoitureService) context.getBean("VoitureServiceImpl");
		IReservationService r = (IReservationService) context.getBean("ReservationServiceImpl");
		IFactureService fact = (IFactureService) context.getBean("serviceFacture");
		SimpleDateFormat fr = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		
		
		System.out.println(v.getVoituresDispByPeriod(fr.parse("2106-05-03"), fr.parse("2106-05-04")));

		System.out.println(v.getVoituresDisp());
		System.out.println(v.getVoituresDispByPeriod(fr.parse("2106-05-02"), fr.parse("2106-05-02")));
		

		
	/*

		Client c1 = new Client("ZABE", "Thierry", sf.parse("1991-05-16"), "0673136946", "12481616", "11 rue des soupirs", "thierry.zabe10@gmail.com" , "France", sf.parse("2009-06-06") , "Saint-di�-des-Vosges", "Jsaispas");
		Client c2 = new Client("BOUMAZA", "Adel", sf.parse("1985-01-12"), "0673136946", "12481616", "11 rue de Paris", "adel10@gmail.com" , "Alg�rie", sf.parse("2009-06-06") , "Saint-di�-des-Vosges", "Flip");
		Client c3 = new Client("DUHEM", "Eric", sf.parse("1990-05-26"), "0673136946", "12481616", "11 rue de Rome", "erik10@gmail.com" , "France", sf.parse("2009-06-06") , "Saint-di�-des-Vosges", "flop");
		Client c4 = new Client("BERNARD", "Thomas", sf.parse("1991-02-16"), "0673136946", "12481616", "11 rue de Strasbourg", "thomas10@gmail.com" , "France", sf.parse("2009-06-06") , "Saint-di�-des-Vosges", "un sombre inconnu");
		Client c5 = new Client("LOUESSE", "Eli", sf.parse("1991-12-16"), "0673136946", "12481616", "11 rue de Madrid", "eli10@gmail.com" , "France", sf.parse("2009-06-06") , "Saint-di�-des-Vosges", "individu lambda");

		
		
		c.addClient(c1);
		c.addClient(c2);
		c.addClient(c3);
		c.addClient(c4);
		c.addClient(c5);
		
		v.addVoiture(new Voiture("xdqsfx", "SDdfsqEK", 300.0, 8000.0, "Q", "e", "QW"));
		r.addReservation(new Reservation(300.0, new Date(), fr.parse("2106-05-02"), fr.parse("2109-05-25"), "324", "sf", 23, "ws"), 3l, 3l);
		v.addVoiture(new Voiture("xqdsfx", "SqfDEK", 300.0, 8000.0, "Q", "e", "QW"));
		r.addReservation(new Reservation(300.0, new Date(), fr.parse("2106-06-02"), fr.parse("2109-07-02"), "324", "sf", 23, "ws"), 3l, 3l);
		*/
		Facture f = new Facture(new Date());
		f = fact.addFacture(1L, 1L, f);
	}

}
