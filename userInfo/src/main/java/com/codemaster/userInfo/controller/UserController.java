package com.codemaster.userInfo.controller;

import com.codemaster.userInfo.dto.UserDTO;
import com.codemaster.userInfo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/fetchAllUsers")
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        List<UserDTO> usersList = userService.getAllUsers();
        return new ResponseEntity<>(usersList, HttpStatus.OK);
    }

    // Add User in to the DB
    @PostMapping("/addUser")
    public ResponseEntity<UserDTO> addUserToDB(@RequestBody UserDTO userDTO){
        UserDTO savedUser = userService.addUserToDB(userDTO);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    // Fetch User By Id
    @GetMapping("/fetchUserById/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Integer id){
        return userService.getUserById(id);
    }

}
