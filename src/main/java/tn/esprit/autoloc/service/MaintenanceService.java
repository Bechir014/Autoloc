package tn.esprit.autoloc.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Maintenance;
import tn.esprit.autoloc.repository.MaintenanceRepository;

import java.util.List;


@Service
@AllArgsConstructor
public class MaintenanceService implements IMaintenanceService {


    private MaintenanceRepository maintenanceRepository;


    @Override
    public List<Maintenance> retrieveAllMaintenances() {
        return (List<Maintenance>) maintenanceRepository.findAll();
    }


    @Override
    public Maintenance addMaintenance(Maintenance m) {
        return maintenanceRepository.save(m);
    }


    @Override
    public Maintenance updateMaintenance(Maintenance m) {
        return maintenanceRepository.save(m);
    }


    @Override
    public Maintenance retrieveMaintenance(Long id) {
        return maintenanceRepository.findById(id).orElse(null);
    }


    @Override
    public void removeMaintenance(Long id) {
        maintenanceRepository.deleteById(id);
    }

}