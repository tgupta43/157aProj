package com.example.mywebapplication2.Performers;

import javax.persistence.*;

@Entity
@Table(name = "Performers")
public class Performer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String band_name;

    @Column(nullable = false)
    private String p_email;

    @Column(nullable = false)
    private String p_pw;

    @Column(nullable = false)
    private Integer p_revenue;

    @Column(nullable = false)
    private String date_available;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBand_name() {
        return band_name;
    }

    public void setBand_name(String band_name) {
        this.band_name = band_name;
    }

    public String getP_email() {
        return p_email;
    }

    public void setP_email(String p_email) {
        this.p_email = p_email;
    }

    public String getP_pw() {
        return p_pw;
    }

    public void setP_pw(String p_pw) {
        this.p_pw = p_pw;
    }

    public Integer getP_revenue() {
        return p_revenue;
    }

    public void setP_revenue(Integer p_revenue) {
        this.p_revenue = p_revenue;
    }

    public String getDate_available() {
        return date_available;
    }

    public void setDate_available(String date_available) {
        this.date_available = date_available;
    }

    @Override
    public String toString() {
        return "Performer{" +
                "id=" + id +
                ", band_name='" + band_name + '\'' +
                ", p_email='" + p_email + '\'' +
                ", p_pw='" + p_pw + '\'' +
                ", p_revenue=" + p_revenue +
                ", date_available='" + date_available + '\'' +
                '}';
    }
}
