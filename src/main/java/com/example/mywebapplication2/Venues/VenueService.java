package com.example.mywebapplication2.Venues;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VenueService {
    @Autowired private VenueRepository repo;

    public List<Venue> listAll(){
        return (List<Venue>) repo.findAll();
    }
    public Optional<Venue> findById(Integer Id){

        return repo.findById(Id);
    }
}
