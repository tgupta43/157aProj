package com.example.mywebapplication2.consumers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsumerService {
    @Autowired private ConsumerRepository repo;

    public List<Consumer> listAll(){
        return (List<Consumer>) repo.findAll();
    }
    public Optional<Consumer> findById(Integer Id){

        return repo.findById(Id);
    }
}
