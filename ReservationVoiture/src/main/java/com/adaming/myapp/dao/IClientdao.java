package com.adaming.myapp.dao;

import java.util.List;

import com.adaming.myapp.entities.Client;

public interface IClientdao {
	
	public Client addClient(Client c);
	public Client getClient(Long id);
	public Client updateClient(Client c);
	public List<Client> getClients();

}
