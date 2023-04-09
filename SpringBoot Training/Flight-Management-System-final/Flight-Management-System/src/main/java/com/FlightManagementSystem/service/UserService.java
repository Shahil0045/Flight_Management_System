package com.FlightManagementSystem.service;

import com.FlightManagementSystem.entity.User;

import java.math.BigInteger;
import java.util.List;

public interface UserService {

    User addUser(User user);
    User viewUser(Integer id);
    List<User> viewUser();

    User updateUser(User user);

    void deleteUser(Integer id);

    int validateUser(User user);

}
