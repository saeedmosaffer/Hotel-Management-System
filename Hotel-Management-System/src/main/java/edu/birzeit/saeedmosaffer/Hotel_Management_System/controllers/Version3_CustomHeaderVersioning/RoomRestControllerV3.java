package edu.birzeit.saeedmosaffer.Hotel_Management_System.controllers.Version3_CustomHeaderVersioning;

import edu.birzeit.saeedmosaffer.Hotel_Management_System.entity.Room;
import edu.birzeit.saeedmosaffer.Hotel_Management_System.services.interfaces.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/rooms")
public class RoomRestControllerV3 {

    private final RoomService roomService;

    @PostMapping(headers = "X-API-VERSION=3")
    public ResponseEntity<Room> createRoom(@RequestHeader("X-API-VERSION") String version, @RequestBody Room room) {
        Room savedRoom = roomService.createRoom(room);
        return new ResponseEntity<>(savedRoom, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}", headers = "X-API-VERSION=3")
    public ResponseEntity<Room> getRoomById(@RequestHeader("X-API-VERSION") String version, @PathVariable("id") Long roomId) {
        Room room = roomService.getRoomById(roomId);
        return room != null ? new ResponseEntity<>(room, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(headers = "X-API-VERSION=3")
    public ResponseEntity<List<Room>> getAllRooms(@RequestHeader("X-API-VERSION") String version) {
        List<Room> rooms = roomService.getAllRooms();
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }

    @GetMapping(value = "/available", headers = "X-API-VERSION=3")
    public ResponseEntity<List<Room>> getAvailableRooms(@RequestHeader("X-API-VERSION") String version) {
        List<Room> rooms = roomService.getAvailableRooms();
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", headers = "X-API-VERSION=3")
    public ResponseEntity<Room> updateRoom(@RequestHeader("X-API-VERSION") String version, @PathVariable("id") Long roomId, @RequestBody Room room) {
        room.setRoomId(roomId);
        Room updatedRoom = roomService.updateRoom(room);
        return updatedRoom != null ? new ResponseEntity<>(updatedRoom, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/{id}", headers = "X-API-VERSION=3")
    public ResponseEntity<String> deleteRoom(@RequestHeader("X-API-VERSION") String version, @PathVariable("id") Long roomId) {
        roomService.deleteRoom(roomId);
        return new ResponseEntity<>("Room successfully deleted!", HttpStatus.OK);
    }
}
