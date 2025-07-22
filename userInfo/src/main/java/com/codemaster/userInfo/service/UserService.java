package com.codemaster.userInfo.service;

import com.codemaster.userInfo.dto.UserDTO;
import com.codemaster.userInfo.entity.User;
import com.codemaster.userInfo.mapper.UserMapper;
import com.codemaster.userInfo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public List<UserDTO> getAllUsers(){
         List<UserDTO> usersList = userRepo.findAll().stream()
                .map(user -> UserMapper.INSTANCE.mapUserToUserDTO(user))
                .collect(Collectors.toList());
         return usersList;
    }

    public UserDTO addUserToDB(UserDTO userDTO){
        User userSaved = userRepo.save(UserMapper.INSTANCE.mapUserDTOToUser(userDTO));
        return UserMapper.INSTANCE.mapUserToUserDTO(userSaved);
    }

    public ResponseEntity<UserDTO> getUserById(Integer id){
        Optional<User> op = userRepo.findById(id);

//        if(op.isPresent()){
//            return new ResponseEntity<>(UserMapper.INSTANCE.mapUserToUserDTO(op.get()), HttpStatus.OK);
//        }
//        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            // Can simply return as below:-
        return op.map(user -> new ResponseEntity<>(UserMapper.INSTANCE.mapUserToUserDTO(user), HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }
}
