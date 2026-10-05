package tn.esprit.autoloc.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Reservation;
import tn.esprit.autoloc.repository.ReservationRepository;

import java.util.List;


@Service
@AllArgsConstructor
public class ReservationService implements IReservationService {


    private ReservationRepository reservationRepository;


    @Override
    public List<Reservation> retrieveAllReservations() {
        return (List<Reservation>) reservationRepository.findAll();
    }


    @Override
    public Reservation addReservation(Reservation r) {
        return reservationRepository.save(r);
    }


    @Override
    public Reservation updateReservation(Reservation r) {
        return reservationRepository.save(r);
    }


    @Override
    public Reservation retrieveReservation(Long id) {
        return reservationRepository.findById(id).orElse(null);
    }


    @Override
    public void removeReservation(Long id) {
        reservationRepository.deleteById(id);
    }

}