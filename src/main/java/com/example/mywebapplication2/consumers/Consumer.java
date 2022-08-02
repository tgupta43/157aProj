package com.example.mywebapplication2.consumers;

import javax.persistence.*;

@Entity
@Table(name = "Consumers")
public class Consumer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true, length = 45)
    private String c_email;

    @Column(length = 12, nullable = false)
    private String c_pw;

    @Column(nullable = false, unique = true, length = 45, name= "first_name")
    private String first_name;

    @Column(nullable = false, unique = true, length = 45, name = "performer_id")
    private Integer performer_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getC_email() {
        return c_email;
    }

    public void setC_email(String c_email) {
        this.c_email = c_email;
    }

    public String getC_pw() {
        return c_pw;
    }

    public void setC_pw(String c_pw) {
        this.c_pw = c_pw;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public Integer getPerformer_id() {
        return performer_id;
    }

    public void setPerformer_id(Integer performer_id) {
        this.performer_id = performer_id;
    }

    @Override
    public String toString() {
        return "Consumer{" +
                "id=" + id +
                ", c_email='" + c_email + '\'' +
                ", c_pw='" + c_pw + '\'' +
                ", first_name='" + first_name + '\'' +
                ", performer_id=" + performer_id +
                '}';
    }
}
