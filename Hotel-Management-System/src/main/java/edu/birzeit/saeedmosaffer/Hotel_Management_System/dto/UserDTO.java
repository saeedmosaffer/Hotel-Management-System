package edu.birzeit.saeedmosaffer.Hotel_Management_System.dto;

import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private String role;

    private String pass;

}