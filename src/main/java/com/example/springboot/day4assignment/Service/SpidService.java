package com.example.springboot.day4assignment.Service;

import com.example.springboot.day4assignment.Entities.Spid;
import com.example.springboot.day4assignment.Entities.Status;
import com.example.springboot.day4assignment.Entities.User;
import com.example.springboot.day4assignment.Repository.RSpid;
import com.example.springboot.day4assignment.Repository.RUser;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class SpidService {


    RSpid spidRepository;
    RUser userRepository;

    SpidService(RSpid spidRepository, RUser userRepository) {
        this.spidRepository = spidRepository;
        this.userRepository = userRepository;
    }

    public Iterable<Spid> retriveAllSpids() {
        return spidRepository.findAll();
    }

    public Spid findSpidById(long id) throws Exception {
        Optional<Spid> spid = spidRepository.findById(id);

        if (!spid.isPresent()) {
            throw new Exception("This spid does not exists");
        }

        return spid.get();
    }

    @Transactional
    public Spid createSpid(Spid spid) throws Exception {
        Optional<Spid> currentSpid = spidRepository.findSpidByUserId(spid.getUserId());
        Optional<User> user = userRepository.findById(spid.getUserId().getId());

        if (!user.isPresent()) {
            throw new Exception("User does not exists");
        }


        if (currentSpid.isPresent()) {
            throw new Exception("User has already created a spid");
        }

        return spidRepository.save(spid);
    }

    public Spid changeStatus(long id) throws Exception {
        Spid spid = findSpidById(id);
        spid.setStatus(Status.READY_FOR_REVIEW);
        return spidRepository.save(spid);
    }

    @Transactional
    public void deleteSpid(long id) {
        spidRepository.deleteById(id);
    }
}