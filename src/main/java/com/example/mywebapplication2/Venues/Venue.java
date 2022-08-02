package com.example.mywebapplication2.Venues;

import javax.persistence.*;

@Entity
@Table(name = "Venues")
public class Venue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private Integer performer_id;

    @Column(nullable = false)
    private Integer capacity;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String date_available;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPerformer_id() {
        return performer_id;
    }

    public void setPerformer_id(Integer performer_id) {
        this.performer_id = performer_id;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate_available() {
        return date_available;
    }

    public void setDate_available(String date_available) {
        this.date_available = date_available;
    }

    @Override
    public String toString() {
        return "Venue{" +
                "id=" + id +
                ", performer_id=" + performer_id +
                ", capacity=" + capacity +
                ", address='" + address + '\'' +
                ", date_available='" + date_available + '\'' +
                '}';
    }
}
