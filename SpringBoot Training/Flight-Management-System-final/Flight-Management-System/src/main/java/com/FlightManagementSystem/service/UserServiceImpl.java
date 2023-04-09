package com.FlightManagementSystem.service;

import com.FlightManagementSystem.entity.User;
import com.FlightManagementSystem.exception.UserNotFoundException;
import com.FlightManagementSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(User user) {
    int validate=validateUser(user);
    if(validate == 1){
        return userRepository.save(user); }
    else{
        try{ throw new ArithmeticException("input a 10 digit number or First digit is 0"); }
        catch(ArithmeticException e){ System.out.println(e.getMessage());}
    }
    return null;

}


    @Override
    public User viewUser(Integer userId) {
        Optional<User> opt =userRepository.findById(userId);
        return opt.orElseThrow(()->new UserNotFoundException("User with given id "+userId+" is not exists!"));

    }

    @Override
    public List<User> viewUser() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        User existingUser = viewUser(user.getUserId());
        existingUser.setUserId(user.getUserId());
        existingUser.setUserType(user.getUserType());
        existingUser.setUserName(user.getUserName());
        existingUser.setUserPassword(user.getUserPassword());
        existingUser.setUserPhone(user.getUserPhone());
        existingUser.setUserEmail(user.getUserEmail());
        return userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(Integer userId) {
        User user=viewUser(userId);
        userRepository.deleteById(user.getUserId());
    }

    @Override
    public int validateUser(User user) {
        int validate=0;
        String str=user.getUserPhone();

        if( (str.length()==10) && str.charAt(0)!='0') {
            validate=1;
        }

        return validate;
    }
}
