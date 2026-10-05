package tn.esprit.autoloc.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Paiement;
import tn.esprit.autoloc.repository.PaiementRepository;

import java.util.List;


@Service
@AllArgsConstructor
public class PaiementService implements IPaiementService {


    private PaiementRepository paiementRepository;


    @Override
    public List<Paiement> retrieveAllPaiements() {
        return (List<Paiement>) paiementRepository.findAll();
    }


    @Override
    public Paiement addPaiement(Paiement p) {
        return paiementRepository.save(p);
    }


    @Override
    public Paiement updatePaiement(Paiement p) {
        return paiementRepository.save(p);
    }


    @Override
    public Paiement retrievePaiement(Long id) {
        return paiementRepository.findById(id).orElse(null);
    }


    @Override
    public void removePaiement(Long id) {
        paiementRepository.deleteById(id);
    }

}