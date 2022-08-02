package com.example.mywebapplication2.consumers;

import com.example.mywebapplication2.Tickets.Tickets;
import com.example.mywebapplication2.Tickets.TicketsService;
import com.example.mywebapplication2.Hosts.Hosts;
import com.example.mywebapplication2.Hosts.HostsService;
import com.example.mywebapplication2.Performers.Performer;
import com.example.mywebapplication2.Performers.PerformerService;
import com.example.mywebapplication2.Venues.Venue;
import com.example.mywebapplication2.Venues.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class ConsumerController {
    @Autowired private ConsumerService service;
    @Autowired private FriendService friendService;
    @Autowired private TicketsService ticketsService;
    @Autowired private HostsService hostsService;

    @Autowired private PerformerService performerService;
    @Autowired private VenueService venueService;

    @GetMapping("/About.html")
    public String showFriendList(Model model) {
        Integer consumerID = 2;
        Optional<Consumer> findConsumer = service.findById(consumerID);
        model.addAttribute("findConsumer", findConsumer);
        System.out.println(findConsumer.toString());
        List<Friend> listFriends = friendService.listAll();
        model.addAttribute("listFriends", listFriends);
        System.out.println(listFriends.toString());
        List<Tickets> listTickets = ticketsService.listAll();
        model.addAttribute("listTickets",listTickets);


        return "About";
    }
    @GetMapping("/Tickets.html")
        public String showTickets(Model model){
            List<Tickets> listTickets = ticketsService.listAll();
            model.addAttribute("listTickets",listTickets);
            Optional<Tickets>ticket1 = ticketsService.findById(1);
            model.addAttribute("ticket1",ticket1);
            Optional<Tickets>ticket2 = ticketsService.findById(2);
            model.addAttribute("ticket2",ticket2);
            Optional<Tickets>ticket3 = ticketsService.findById(3);
            model.addAttribute("ticket3",ticket3);
            Optional<Tickets>ticket4 = ticketsService.findById(4);
            model.addAttribute("ticket4",ticket4);

        return "Tickets";
        }

        @GetMapping("/Venue.html")
    public String showVenue(Model model){
        List<Hosts> listHosts = hostsService.listAll();
        model.addAttribute("listHosts", listHosts);
        Optional<Hosts>host1 = hostsService.findById(1);
        model.addAttribute("host1",host1);
        Optional<Venue> listVenue2 = venueService.findById(2);
        model.addAttribute("listVenue2", listVenue2);

        return "Venue";
        }

    @GetMapping("/Performer.html")
    public String showPerformer(Model model){
        List<Performer> listPerformers = performerService.listAll();
        model.addAttribute("listPerformers",listPerformers);
        Optional<Performer> performer2 = performerService.findById(1);
        model.addAttribute("performer2",performer2);
        Optional<Hosts>dateAvailable = hostsService.findById(1);
        model.addAttribute("dateAvailable",dateAvailable);
        Optional<Venue> listVenue2 = venueService.findById(2);
        model.addAttribute("listVenue2", listVenue2);

        return "Performer";
    }





//    @GetMapping("/About.html")
//    public String redirectAbout() {
//        return "About";
//    }
}
