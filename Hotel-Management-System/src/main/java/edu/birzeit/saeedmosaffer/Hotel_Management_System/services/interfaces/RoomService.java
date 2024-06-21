package edu.birzeit.saeedmosaffer.Hotel_Management_System.services.interfaces;

import edu.birzeit.saeedmosaffer.Hotel_Management_System.entity.Room;

import java.util.List;

public interface RoomService {
    Room createRoom(Room room);
    Room getRoomById(Long roomId);
    List<Room> getAllRooms();
    List<Room> getAvailableRooms();
    Room updateRoom(Room room);
    void deleteRoom(Long roomId);
}

