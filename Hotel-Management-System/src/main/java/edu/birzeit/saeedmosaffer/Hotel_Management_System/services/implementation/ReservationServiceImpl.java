package edu.birzeit.saeedmosaffer.Hotel_Management_System.services.implementation;

import edu.birzeit.saeedmosaffer.Hotel_Management_System.entity.Reservation;
import edu.birzeit.saeedmosaffer.Hotel_Management_System.repository.ReservationRepository;
import edu.birzeit.saeedmosaffer.Hotel_Management_System.services.interfaces.ReservationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepository reservationRepository;

    @Override
    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation getReservationById(Long reservationId) {
        return reservationRepository.findById(reservationId).orElse(null);
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public List<Reservation> getReservationsByCustomerId(Long customerId) {
        return reservationRepository.findByUserId(customerId);
    }

    @Override
    public List<Reservation> getReservationsByRoomId(Long roomId) {
        return reservationRepository.findByRoomRoomId(roomId);
    }

    @Override
    public Reservation updateReservation(Reservation reservation) {
        Reservation existingReservation = reservationRepository.findById(reservation.getReservationId()).orElse(null);
        if (existingReservation != null) {
            existingReservation.setUser(reservation.getUser());
            existingReservation.setRoom(reservation.getRoom());
            existingReservation.setReservationDate(reservation.getReservationDate());
            existingReservation.setCheckInDate(reservation.getCheckInDate());
            existingReservation.setCheckOutDate(reservation.getCheckOutDate());
            existingReservation.setStatus(reservation.getStatus());
            return reservationRepository.save(existingReservation);
        }
        return null;
    }

    @Override
    public void deleteReservation(Long reservationId) {
        reservationRepository.deleteById(reservationId);
    }
}
