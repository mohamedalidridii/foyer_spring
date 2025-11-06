package org.example.tpfoyer.services;


import org.example.tpfoyer.entities.Reservation;

import java.util.List;

public interface IReservationService {
    Reservation addOrUpdateReservation(Reservation reservation);
    void deleteReservation(String id);
    List<Reservation> getReservation();
    Reservation getReservation(String id);
}
