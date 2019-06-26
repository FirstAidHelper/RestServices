package com.ibm.fah.rest.services;

import com.ibm.fah.rest.dto.UserDTO;
import com.ibm.fah.rest.dto.UserUpdateDTO;

public interface UserService {
    public UserDTO addUser(UserDTO userDTO);
    public UserDTO getUser(String id);
    public UserDTO updateUser(UserUpdateDTO userUpdateDTO, String id);
    public void deleteUser(String id);
}
