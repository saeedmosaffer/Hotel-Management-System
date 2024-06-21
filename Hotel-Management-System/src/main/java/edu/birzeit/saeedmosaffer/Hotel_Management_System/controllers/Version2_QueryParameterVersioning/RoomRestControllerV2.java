package edu.birzeit.saeedmosaffer.Hotel_Management_System.controllers.Version2_QueryParameterVersioning;

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
public class RoomRestControllerV2 {

    private final RoomService roomService;

    @PostMapping(params = "version=2")
    public ResponseEntity<Room> createRoom(@RequestParam("version") String version, @RequestBody Room room) {
        Room savedRoom = roomService.createRoom(room);
        return new ResponseEntity<>(savedRoom, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}", params = "version=2")
    public ResponseEntity<Room> getRoomById(@RequestParam("version") String version, @PathVariable("id") Long roomId) {
        Room room = roomService.getRoomById(roomId);
        return room != null ? new ResponseEntity<>(room, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(params = "version=2")
    public ResponseEntity<List<Room>> getAllRooms(@RequestParam("version") String version) {
        List<Room> rooms = roomService.getAllRooms();
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }

    @GetMapping(value = "/available", params = "version=2")
    public ResponseEntity<List<Room>> getAvailableRooms(@RequestParam("version") String version) {
        List<Room> rooms = roomService.getAvailableRooms();
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", params = "version=2")
    public ResponseEntity<Room> updateRoom(@RequestParam("version") String version, @PathVariable("id") Long roomId, @RequestBody Room room) {
        room.setRoomId(roomId);
        Room updatedRoom = roomService.updateRoom(room);
        return updatedRoom != null ? new ResponseEntity<>(updatedRoom, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/{id}", params = "version=2")
    public ResponseEntity<String> deleteRoom(@RequestParam("version") String version, @PathVariable("id") Long roomId) {
        roomService.deleteRoom(roomId);
        return new ResponseEntity<>("Room successfully deleted!", HttpStatus.OK);
    }
}
