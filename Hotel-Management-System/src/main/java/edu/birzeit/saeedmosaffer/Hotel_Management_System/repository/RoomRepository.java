package edu.birzeit.saeedmosaffer.Hotel_Management_System.repository;

import edu.birzeit.saeedmosaffer.Hotel_Management_System.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findByStatus(String status);
}