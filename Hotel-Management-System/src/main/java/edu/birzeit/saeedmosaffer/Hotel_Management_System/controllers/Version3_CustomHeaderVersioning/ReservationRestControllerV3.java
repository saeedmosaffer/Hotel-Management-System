package edu.birzeit.saeedmosaffer.Hotel_Management_System.controllers.Version3_CustomHeaderVersioning;

import edu.birzeit.saeedmosaffer.Hotel_Management_System.entity.Reservation;
import edu.birzeit.saeedmosaffer.Hotel_Management_System.services.interfaces.ReservationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/reservations")
public class ReservationRestControllerV3 {

    private final ReservationService reservationService;

    @PostMapping(headers = "X-API-VERSION=3")
    public ResponseEntity<Reservation> createReservation(@RequestHeader("X-API-VERSION") String version, @RequestBody Reservation reservation) {
        Reservation savedReservation = reservationService.createReservation(reservation);
        return new ResponseEntity<>(savedReservation, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}", headers = "X-API-VERSION=3")
    public ResponseEntity<Reservation> getReservationById(@RequestHeader("X-API-VERSION") String version, @PathVariable("id") Long reservationId) {
        Reservation reservation = reservationService.getReservationById(reservationId);
        return reservation != null ? new ResponseEntity<>(reservation, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(headers = "X-API-VERSION=3")
    public ResponseEntity<List<Reservation>> getAllReservations(@RequestHeader("X-API-VERSION") String version) {
        List<Reservation> reservations = reservationService.getAllReservations();
        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }

    @GetMapping(value = "/customer/{customerId}", headers = "X-API-VERSION=3")
    public ResponseEntity<List<Reservation>> getReservationsByCustomerId(@RequestHeader("X-API-VERSION") String version, @PathVariable("customerId") Long customerId) {
        List<Reservation> reservations = reservationService.getReservationsByCustomerId(customerId);
        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }

    @GetMapping(value = "/room/{roomId}", headers = "X-API-VERSION=3")
    public ResponseEntity<List<Reservation>> getReservationsByRoomId(@RequestHeader("X-API-VERSION") String version, @PathVariable("roomId") Long roomId) {
        List<Reservation> reservations = reservationService.getReservationsByRoomId(roomId);
        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", headers = "X-API-VERSION=3")
    public ResponseEntity<Reservation> updateReservation(@RequestHeader("X-API-VERSION") String version, @PathVariable("id") Long reservationId, @RequestBody Reservation reservation) {
        reservation.setReservationId(reservationId);
        Reservation updatedReservation = reservationService.updateReservation(reservation);
        return updatedReservation != null ? new ResponseEntity<>(updatedReservation, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/{id}", headers = "X-API-VERSION=3")
    public ResponseEntity<String> deleteReservation(@RequestHeader("X-API-VERSION") String version, @PathVariable("id") Long reservationId) {
        reservationService.deleteReservation(reservationId);
        return new ResponseEntity<>("Reservation successfully deleted!", HttpStatus.OK);
    }
}
