package com.example.mywebapplication2.consumers;

import javax.persistence.*;

@Entity
@Table(name = "Friends")
public class Friend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private Integer consumer_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getConsumer_id() {
        return consumer_id;
    }

    public void setConsumer_id(Integer consumer_id) {
        this.consumer_id = consumer_id;
    }

    @Override
    public String toString() {
        return "Friend{" +
                "id=" + id +
                ", consumer_id=" + consumer_id +
                '}';
    }
}
