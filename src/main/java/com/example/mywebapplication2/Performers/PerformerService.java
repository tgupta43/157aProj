package com.example.mywebapplication2.Performers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PerformerService {
    @Autowired private PerformerRepository repo;

    public List<Performer> listAll(){
        return (List<Performer>) repo.findAll();
    }
    public Optional<Performer> findById(Integer Id){

        return repo.findById(Id);
    }
}
