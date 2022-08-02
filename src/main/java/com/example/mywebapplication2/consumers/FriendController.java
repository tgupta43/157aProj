//package com.example.mywebapplication2.friends;
//
//import com.example.mywebapplication2.consumers.Consumer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import java.util.List;
//import java.util.Optional;
//
//@Controller
//public class FriendController {
//    @Autowired
//    private FriendService service;
//
//    @GetMapping("/About.html")
//    public String showFriendList(Model model) {
//        List<Friend> listFriends = service.listAll();
//        model.addAttribute("listFriends", listFriends);
//
//        return "About";
//    }
//}
