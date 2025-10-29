package com.example.project_15.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.project_15.dto.UserDto;
import com.example.project_15.models.User;
import com.example.project_15.Repository.UserRepository;

@Service
public class UserService{
   
    @Autowired
    private PasswordEncoder passwordEncoder;
   
    @Autowired
    private UserRepository userReporsitory;

    public User save(UserDto userDto) {
    	 User user = new User(userDto.getFullname(), userDto.getPhoneNo(), userDto.getEmail(), passwordEncoder.encode(userDto.getPassword()));
        return userReporsitory.save(user);
    }
}