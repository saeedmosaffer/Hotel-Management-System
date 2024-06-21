package edu.birzeit.saeedmosaffer.Hotel_Management_System.services.interfaces;

import edu.birzeit.saeedmosaffer.Hotel_Management_System.dto.UserDTO;
import edu.birzeit.saeedmosaffer.Hotel_Management_System.entity.User;


import java.util.List;
import java.util.Optional;

public interface UserService {
    UserDTO createUser(UserDTO userDTO);
    UserDTO getUserById(Long id);
    UserDTO updateUser(UserDTO userDTO, Long id);
    void deleteUser(Long id);
    List<UserDTO> getAllUsers();
    UserDTO signUp(UserDTO userDTO);

}
