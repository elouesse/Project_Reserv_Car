package com.adaming.myapp.dao;

import java.util.List;

import com.adaming.myapp.entities.Reservation;

public interface IReservationDao {
	
	public Reservation addReservation(Reservation r, Long idClient, Long idVoiture);
	public Reservation getReservation(Long id);
	public Reservation updateReservation(Reservation c);
	public List<Reservation> getHistorique();

}
