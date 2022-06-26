package com.example.springboot.day4assignment.Service;

import com.example.springboot.day4assignment.Entities.User;
import com.example.springboot.day4assignment.Repository.RUser;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {


    RUser userRepository;

    UserService(RUser userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) throws Exception {
        Optional<User> findIfUserExists = userRepository.findUserById(user.getId());

        if (findIfUserExists.isPresent()) {
            throw new Exception("User already exists");
        }
        return userRepository.save(user);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    public User updateUser(User user, long id) throws Exception {
        if (userRepository.findUserById(id).isPresent()) {
            user.setId(id);
            return userRepository.save(user);
        } else {
            throw new Exception("User does not exists");
        }
    }
}