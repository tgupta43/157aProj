package com.example.mywebapplication2.Tickets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketsService {
    @Autowired private TicketsRepository repo;

    public List<Tickets> listAll(){
        return (List<Tickets>) repo.findAll();
    }

    public Optional<Tickets> findById(Integer Id){
        return repo.findById(Id);
    }


}
