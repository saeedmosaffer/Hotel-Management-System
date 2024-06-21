package edu.birzeit.saeedmosaffer.Hotel_Management_System.services.implementation;

import edu.birzeit.saeedmosaffer.Hotel_Management_System.entity.Room;
import edu.birzeit.saeedmosaffer.Hotel_Management_System.repository.RoomRepository;
import edu.birzeit.saeedmosaffer.Hotel_Management_System.services.interfaces.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;

    @Override
    public Room createRoom(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public Room getRoomById(Long roomId) {
        return roomRepository.findById(roomId).orElse(null);
    }

    @Override
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @Override
    public List<Room> getAvailableRooms() {
        return roomRepository.findByStatus("Available");
    }

    @Override
    public Room updateRoom(Room room) {
        Room existingRoom = roomRepository.findById(room.getRoomId()).orElse(null);
        if (existingRoom != null) {
            existingRoom.setRoomType(room.getRoomType());
            existingRoom.setPrice(room.getPrice());
            existingRoom.setFacilities(room.getFacilities());
            existingRoom.setCapacity(room.getCapacity());
            existingRoom.setSize(room.getSize());
            existingRoom.setStatus(room.getStatus());
            return roomRepository.save(existingRoom);
        }
        return null;
    }

    @Override
    public void deleteRoom(Long roomId) {
        roomRepository.deleteById(roomId);
    }
}

