package com.example.springboot.day4assignment.Repository;

import com.example.springboot.day4assignment.Entities.Spid;
import com.example.springboot.day4assignment.Entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface RSpid extends CrudRepository<Spid, Long> {
    Optional<Spid> findSpidByUserId(User user);
}