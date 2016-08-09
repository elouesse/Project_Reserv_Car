package com.adaming.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adaming.myapp.dao.IClientdao;
import com.adaming.myapp.entities.Client;

@Service
@Transactional
public class ClientServiceImpl implements IClientService {
	
	@Autowired
	private IClientdao daoClient;

	public void setDaoClient(IClientdao daoClient) {
		this.daoClient = daoClient;
	}

	@Override
	public Client addClient(Client c) {
		return daoClient.addClient(c);
	}

	@Override
	public Client getClient(Long id) {
		return daoClient.getClient(id);
	}

	@Override
	public Client updateClient(Client c) {
		return daoClient.updateClient(c);
	}

	@Override
	public List<Client> getClients() {
		return daoClient.getClients();
	}

}
