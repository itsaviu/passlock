package com.uas.passlock.service;

import com.uas.passlock.models.dto.UserDto;
import com.uas.passlock.models.entity.User;
import com.uas.passlock.repo.UserRepository;
import com.uas.passlock.util.SecurityUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SecurityUtil securityUtil;

    public User saveUser(UserDto userDto) {
        log.info("Creating user {}", userDto.getUsername());
        return userRepository.save(new User(userDto.getUsername(), securityUtil.encodePassword(userDto.getPassword()), userDto.getEmailId(), userDto.getMobileNumber()));
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("Cannot find the user"));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
