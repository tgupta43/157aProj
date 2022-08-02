package com.example.mywebapplication2.Hosts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HostsService {
    @Autowired private HostsRepository repo;

    public List<Hosts> listAll(){
        return (List<Hosts>) repo.findAll();
    }
    public Optional<Hosts> findById(Integer Id){

        return repo.findById(Id);
    }
}
