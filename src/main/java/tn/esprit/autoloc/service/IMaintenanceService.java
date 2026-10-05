package tn.esprit.autoloc.service;


import tn.esprit.autoloc.domain.Maintenance;

import java.util.List;


public interface IMaintenanceService {


    List<Maintenance> retrieveAllMaintenances();


    Maintenance addMaintenance(Maintenance m);


    Maintenance updateMaintenance(Maintenance m);


    Maintenance retrieveMaintenance(Long id);


    void removeMaintenance(Long id);

}