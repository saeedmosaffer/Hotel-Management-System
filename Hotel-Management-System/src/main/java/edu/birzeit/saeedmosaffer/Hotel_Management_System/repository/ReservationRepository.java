package edu.birzeit.saeedmosaffer.Hotel_Management_System.repository;

import edu.birzeit.saeedmosaffer.Hotel_Management_System.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByUserId(Long customerId);
    List<Reservation> findByRoomRoomId(Long roomId);
}