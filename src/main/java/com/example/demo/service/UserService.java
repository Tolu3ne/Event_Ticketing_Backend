package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.common.dto.CreateUserDto;
import com.example.demo.common.dto.LoginRequestDto;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.NotFoundException;
import com.example.demo.model.User;
import com.example.demo.model.repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    private boolean checkUser (CreateUserDto userDto){
        boolean usernameCheck = (userRepository.findByUsername(userDto.getUsername())) == null;
        boolean emailCheck = (userRepository.findByEmail(userDto.getEmail())) == null;
        System.out.println(usernameCheck);
        System.out.print(emailCheck);
        return (usernameCheck && emailCheck);
    }

    public User createUser(CreateUserDto userDto) {
        if (!checkUser(userDto)) throw new BadRequestException("Username or email already exists in the database!");
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        User user = new User(userDto);
        return userRepository.save(user);
    }

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    public User findUserById(long id) {
        User user = userRepository.findById(id);
        if (user != null) {
            return user;
        }
        else {
            throw new NotFoundException("User with id " + id + " not found");
        }
    }

    public boolean checkCredentials(LoginRequestDto request){
        try {
            User user = userRepository.findByUsername(request.getUsername());
            return checkPassword(request.getPassword(), user.getPassword());
        } catch (Exception e) {
            throw e;
        }
    }

    private boolean checkPassword(String rawPassword, String hashedPassword) {
        return passwordEncoder.matches(rawPassword, hashedPassword);
    }

}
