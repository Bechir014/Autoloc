
package tn.esprit.autoloc.service;

import java.util.List;
import java.util.stream.StreamSupport;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import lombok.RequiredArgsConstructor;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.repository.ClientRepository;

@Service
@RequiredArgsConstructor
public class ClientService implements IclientService {

    private final ClientRepository clrepos;

    @Override
    public List<Client> retrieveAllClients() {
        return StreamSupport.stream(
                clrepos.findAll().spliterator(), false
        ).toList();
    }

    @Override
    public Client retrieveClient(Long idClient) {
        return clrepos.findById(idClient)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Client introuvable"
                ));
    }

    @Override
    public Client addClient(Client c) {
        c.setIdClient(null);
        return clrepos.save(c);
    }

    @Override
    public Client updateClient(Client c) {
        if (c.getIdClient() == null ||
                !clrepos.existsById(c.getIdClient())) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Client introuvable"
            );
        }
        return clrepos.save(c);
    }

    @Override
    public void removeClient(Long idClient) {
        retrieveClient(idClient);
        clrepos.deleteById(idClient);
    }

    @Override
    public List<Client> addClients(List<Client> clients) {
        clients.forEach(c -> c.setIdClient(null));
        return StreamSupport.stream(
                clrepos.saveAll(clients).spliterator(), false
        ).toList();
    }
}
