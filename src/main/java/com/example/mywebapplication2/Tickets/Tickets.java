package com.example.mywebapplication2.Tickets;

import javax.persistence.*;

@Entity
@Table(name = "Tickets")
public class Tickets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private Integer venue_id;

    @Column(nullable = false, unique = true)
    private Integer performer_id;

    @Column(nullable = false, unique = true, name="consumer_id")
    private Integer consumer_id;

    @Column(nullable = false)
    private String the_date;

    @Column(nullable = false)
    private Integer price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVenue_id() {
        return venue_id;
    }

    public void setVenue_id(Integer venue_id) {
        this.venue_id = venue_id;
    }

    public Integer getPerformer_id() {
        return performer_id;
    }

    public void setPerformer_id(Integer performer_id) {
        this.performer_id = performer_id;
    }

    public Integer getConsumer_id() {
        return consumer_id;
    }

    public void setConsumer_id(Integer consumer_id) {
        this.consumer_id = consumer_id;
    }

    public String getThe_date() {
        return the_date;
    }

    public void setThe_date(String the_date) {
        this.the_date = the_date;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Tickets{" +
                "id=" + id +
                ", venue_id=" + venue_id +
                ", performer_id=" + performer_id +
                ", consumer_id=" + consumer_id +
                ", the_date='" + the_date + '\'' +
                ", price=" + price +
                '}';
    }
}
