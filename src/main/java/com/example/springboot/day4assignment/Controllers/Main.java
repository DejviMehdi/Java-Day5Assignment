package com.example.springboot.day4assignment.Controllers;

import com.example.springboot.day4assignment.Entities.Spid;
import com.example.springboot.day4assignment.Entities.User;
import com.example.springboot.day4assignment.Service.SpidService;
import com.example.springboot.day4assignment.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class Main {

    UserService userService;
    SpidService spidService;

    Main(UserService userService, SpidService spidService) {
        this.userService = userService;
        this.spidService = spidService;
    }

    // Users
    @PostMapping( "/users")
    public ResponseEntity<User> createUser(@RequestBody User user) throws Exception {
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.OK);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable long id) throws Exception {
        return new ResponseEntity<>(userService.updateUser(user, id), HttpStatus.OK);
    }

    // SPIDs
    @GetMapping("/spid")
    public ResponseEntity<List<Spid>> getAllSpids() {
        return new ResponseEntity(spidService.retriveAllSpids(), HttpStatus.OK);
    }

    @GetMapping("/spid/{id}")
    public ResponseEntity<Spid> getSpid(@PathVariable(name = "id") long id) throws Exception {
        return new ResponseEntity(spidService.findSpidById(id), HttpStatus.OK);
    }

    @PostMapping("/spid")
    public ResponseEntity<Spid> createSpid(@RequestBody Spid spid) throws Exception {
        return new ResponseEntity(spidService.createSpid(spid), HttpStatus.OK);
    }

    @PutMapping("/spid/{id}")
    public ResponseEntity<Spid> changeSpidStatus(@PathVariable(name = "id") long id) throws Exception {
        return new ResponseEntity(spidService.changeStatus(id), HttpStatus.OK);
    }

    @DeleteMapping("/spid/{id}")
    public ResponseEntity<Spid> deleteSpid(@PathVariable(name = "id") long id) throws Exception {
        return new ResponseEntity("SPID was deleted successfully", HttpStatus.OK);
    }
}