package edu.birzeit.saeedmosaffer.Hotel_Management_System.services.interfaces;

import edu.birzeit.saeedmosaffer.Hotel_Management_System.entity.Reservation;

import java.util.List;

public interface ReservationService {
    Reservation createReservation(Reservation reservation);
    Reservation getReservationById(Long reservationId);
    List<Reservation> getAllReservations();
    List<Reservation> getReservationsByCustomerId(Long customerId);
    List<Reservation> getReservationsByRoomId(Long roomId);
    Reservation updateReservation(Reservation reservation);
    void deleteReservation(Long reservationId);
}

