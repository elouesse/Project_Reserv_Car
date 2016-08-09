package com.adaming.myapp.service;

import java.util.List;

import com.adaming.myapp.entities.Client;

public interface IClientService {
	
	public Client addClient(Client c);
	public Client getClient(Long id);
	public Client updateClient(Client c);
	public List<Client> getClients();

}
