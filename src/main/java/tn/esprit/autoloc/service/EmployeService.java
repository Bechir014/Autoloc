package tn.esprit.autoloc.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.repository.EmployeRepository;

import java.util.List;


@Service
@AllArgsConstructor
public class EmployeService implements IEmployeService {


    private EmployeRepository employeRepository;


    @Override
    public List<Employe> retrieveAllEmployes() {
        return (List<Employe>) employeRepository.findAll();
    }


    @Override
    public Employe addEmploye(Employe e) {
        return employeRepository.save(e);
    }


    @Override
    public Employe updateEmploye(Employe e) {
        return employeRepository.save(e);
    }


    @Override
    public Employe retrieveEmploye(Long id) {
        return employeRepository.findById(id).orElse(null);
    }


    @Override
    public void removeEmploye(Long id) {
        employeRepository.deleteById(id);
    }

}