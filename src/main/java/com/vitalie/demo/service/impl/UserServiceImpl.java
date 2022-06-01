package com.vitalie.demo.service.impl;

import com.vitalie.demo.entity.User;
import com.vitalie.demo.repository.UserRepository;
import com.vitalie.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;



    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User getUserById(int userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public User addOrUpdateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User deleteUser(int userId) throws Exception {
        User deletedUser =null;
        try{
            deletedUser=userRepository.findById(userId).orElse(null);
            if(deletedUser==null){
                throw new Exception("user è null");
            }else{
                userRepository.deleteById(userId);
            }
        }catch(Exception ex){
            throw ex;
        }

        return deletedUser;
    }
}
