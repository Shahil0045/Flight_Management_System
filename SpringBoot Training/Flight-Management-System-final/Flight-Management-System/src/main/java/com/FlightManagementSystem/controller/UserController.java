package com.FlightManagementSystem.controller;

import com.FlightManagementSystem.entity.User;
import com.FlightManagementSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping(value ="/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/addUser")
    public ResponseEntity<User> addUser(@Valid @RequestBody User user){
        return new ResponseEntity<User>(userService.addUser(user), HttpStatus.CREATED);

    }

    @GetMapping(value = "/viewUser/{user_id}")
    public ResponseEntity<User> viewUser(@PathVariable Integer user_id){
        return new ResponseEntity<User>(userService.viewUser(user_id),HttpStatus.OK);
    }

    @GetMapping(value = "/viewUser")
    public ResponseEntity<List<User>> viewUser(){
        return new ResponseEntity<List<User>>(userService.viewUser(),HttpStatus.OK);
    }
    @PutMapping(value="/updateUser")
    public ResponseEntity<User> updateUser(@Valid  @RequestBody User user){
        return new ResponseEntity<User>(userService.updateUser(user),HttpStatus.OK);

    }

@DeleteMapping(value="/deleteUser/{userId}")
public ResponseEntity<String> deleteUser(@PathVariable Integer userId) {
    userService.deleteUser(userId);
    return new ResponseEntity<String>("user with ID "+userId+" deleted successfully" , HttpStatus.OK);
    }

}