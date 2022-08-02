package com.example.mywebapplication2.consumers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FriendService {
    @Autowired private FriendRepository repo;

    public List<Friend> listAll(){
        return (List<Friend>) repo.findAll();
    }

    public Optional<Friend> findById(Integer Id){
        Integer friendId = 2;
        return repo.findById(friendId);
    }
}
