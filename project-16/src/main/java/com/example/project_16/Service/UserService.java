package com.example.project_16.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.project_16.dto.UserDto;
import com.example.project_16.Models.User;
import com.example.project_16.Repository.UserRepository;

@Service
public class UserService{
   
    @Autowired
    private PasswordEncoder passwordEncoder;
   
    @Autowired
    private UserRepository userRepository;

    public User save(UserDto userDto) {
    	 User user = new User(userDto.getName(), userDto.getDob(), userDto.getAddress(), userDto.getEmail(), passwordEncoder.encode(userDto.getPassword()));
        return userRepository.save(user);
    }
}