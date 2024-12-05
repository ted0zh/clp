package com.learningPlatform.CLP.controller;

import com.learningPlatform.CLP.data.dto.UserDto;
import com.learningPlatform.CLP.data.entity.Users;
import com.learningPlatform.CLP.exceptions.NoSuchUserException;
import com.learningPlatform.CLP.service.serviceImpl.UserServiceImpl;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {
    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Secured("ADMIN")
    @GetMapping("/all")
    public List<Users> getUsers(){
        return userService.fetchUsers();
    }

    @Secured("ADMIN")
    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable Integer id){
        try{
            userService.getUser(id);
            return ResponseEntity.status(HttpStatus.FOUND).build();
        }catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @Secured("ADMIN")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id,
                                    @RequestBody UserDto dto){
        try {
            userService.updateUser(id,dto);
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch (NoSuchUserException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @Secured("ADMIN")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id){
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
