package com.degree.studyitserver.controller;

import com.degree.studyitserver.domain.dto.UserDto;
import com.degree.studyitserver.domain.entity.User;
import com.degree.studyitserver.mapper.UserMapper;
import com.degree.studyitserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "users")
public class UserController {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserController(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @GetMapping(path = "/find-all")
    @PreAuthorize("hasRole('ADMIN')")
    public List<UserDto> findAll() {
        List<User> users = userRepository.findAll();
        return  userMapper.toDtos(users);
    }
}

