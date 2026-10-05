package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.repository.ClientRepository;

import java.util.List;

public class ClientService implements IclientService{
    ClientRepository clrepos;
    @Override
    public List<Client> retrieveAllClients() {
        return (List<Client>) clrepos.findAll();
    }

    @Override
    public Client addClient(Client c) {
        clrepos.save(c);
        return null;
    }

    @Override
    public Client updateClient(Client c) {
        return clrepos.save(c);
    }

    @Override
    public Client retrieveClient(Long idClient) {
        return clrepos.findById(idClient).orElse(null);
    }

    @Override
    public void removeClient(Long idClient) {
        clrepos.deleteById(idClient);

    }

    @Override
    public List<Client> addClients(List<Client> clients) {
        return(List<Client>) clrepos.saveAll(clients);
    }
}
