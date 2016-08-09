package com.adaming.myapp.service;

import java.util.List;

import com.adaming.myapp.entities.Reservation;

public interface IReservationService {
	
	public Reservation addReservation(Reservation r, Long idClient, Long idVoiture);
	public Reservation getReservation(Long id);
	public Reservation updateReservation(Reservation c);
	public List<Reservation> getHistorique();

}
