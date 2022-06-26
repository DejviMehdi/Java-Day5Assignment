package com.example.springboot.day4assignment.Repository;

import com.example.springboot.day4assignment.Entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RUser extends CrudRepository <User, Long> {
    List<User> findUserById(long id);
}
