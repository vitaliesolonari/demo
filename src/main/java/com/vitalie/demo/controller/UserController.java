package com.vitalie.demo.controller;

import com.vitalie.demo.entity.User;
import com.vitalie.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/allUsers")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = null;
        try{
            users=userService.getAllUsers();
        }catch(Exception e){
            e.getMessage();
        }

        return new ResponseEntity<List<User>>(users,HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<User> getUsersById(@PathVariable("id") int userId){
        User user = null;
        try{
            user=userService.getUserById(userId);
        }catch(Exception e){
            e.getMessage();
        }

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @PostMapping ("/addOrUpdate")
    public ResponseEntity<User> addOrUpdate(@RequestBody User user){
        User newUser = null;
        try{
            newUser=userService.addOrUpdateUser(user);
        }catch(Exception e){
            e.getMessage();
        }

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @DeleteMapping ("/deleteById/{id}")
    public ResponseEntity<User> deleteById(@PathVariable("id") int userId){
        User deletedUser = null;
        try{
            deletedUser=userService.deleteUser(userId);
        }catch(Exception e){
            e.getMessage();
        }

        return new ResponseEntity<User>(deletedUser, HttpStatus.OK);
    }
}
