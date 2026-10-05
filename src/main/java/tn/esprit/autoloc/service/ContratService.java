package tn.esprit.autoloc.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Contrat;
import tn.esprit.autoloc.repository.ContratRepository;

import java.util.List;


@Service
@AllArgsConstructor
public class ContratService implements IContratService {


    private ContratRepository contratRepository;


    @Override
    public List<Contrat> retrieveAllContrats() {
        return (List<Contrat>) contratRepository.findAll();
    }


    @Override
    public Contrat addContrat(Contrat c) {
        return contratRepository.save(c);
    }


    @Override
    public Contrat updateContrat(Contrat c) {
        return contratRepository.save(c);
    }


    @Override
    public Contrat retrieveContrat(Long id) {
        return contratRepository.findById(id).orElse(null);
    }


    @Override
    public void removeContrat(Long id) {
        contratRepository.deleteById(id);
    }

}