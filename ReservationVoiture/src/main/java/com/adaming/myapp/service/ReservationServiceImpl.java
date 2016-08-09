package com.adaming.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adaming.myapp.dao.IReservationDao;
import com.adaming.myapp.entities.Reservation;

@Service
@Transactional
public class ReservationServiceImpl implements IReservationService {
	
	@Autowired
	private IReservationDao daoReserv;

	public void setDaoReserv(IReservationDao daoReserv) {
		this.daoReserv = daoReserv;
	}

	@Override
	public Reservation addReservation(Reservation r, Long idClient,
			Long idVoiture) {
		return daoReserv.addReservation(r, idClient, idVoiture);
	}

	@Override
	public Reservation getReservation(Long id) {
		return daoReserv.getReservation(id);
	}

	@Override
	public Reservation updateReservation(Reservation c) {
		return daoReserv.updateReservation(c);
	}

	@Override
	public List<Reservation> getHistorique() {
		return daoReserv.getHistorique();
	}

}
