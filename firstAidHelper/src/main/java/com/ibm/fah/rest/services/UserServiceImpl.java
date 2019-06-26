package com.ibm.fah.rest.services;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.fah.mongodb.models.User;
import com.ibm.fah.mongodb.repositories.UserRepository;
import com.ibm.fah.rest.dto.UserDTO;
import com.ibm.fah.rest.dto.UserUpdateDTO;
import com.ibm.fah.rest.exception.EntityNotFoundException;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO addUser(UserDTO userDTO) {
        /**
         * We are manually creating {@link User} object however there is mapper
         * available to convert to-from {@link UserDTO}.
         */
        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setPhone(userDTO.getPhone());
        user.setBloodType(userDTO.getBloodType());
        user.setDisability(userDTO.getDisability());
        userRepository.save(user);

        /* set generated user id to response object */
        userDTO.setId(user.getId());
        userDTO.setPassword("");
        return userDTO;
    }

    @Override
    public UserDTO getUser(String id) {
        Optional<User> user = userRepository.findById(id);
        if (Objects.isNull(user)) {
            /* handle this exception using {@link RestExceptionHandler} */
            throw new EntityNotFoundException(User.class, id);
        }
        return (user.isPresent() ? new UserDTO().build(user.get()) : null);
    }

    @Override
    public UserDTO updateUser(UserUpdateDTO userUpdateDTO, String id) {
        Optional<User> user = userRepository.findById(id);
        if (Objects.isNull(user)) {
            /* handle this exception using {@link RestExceptionHandler} */
            throw new EntityNotFoundException(User.class, id);
        }
        if (!user.isPresent()) {
        	return null;
        } 
        User actualUser = user.get();
        actualUser.setFirstName(userUpdateDTO.getFirstName());
        actualUser.setLastName(userUpdateDTO.getLastName());
        actualUser.setPhone(userUpdateDTO.getPhone());
        actualUser.setBloodType(userUpdateDTO.getBloodType());
        actualUser.setDisability(userUpdateDTO.getDisability());
        userRepository.save(actualUser);
        return new UserDTO().build(actualUser);
    }

    @Override
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}	
