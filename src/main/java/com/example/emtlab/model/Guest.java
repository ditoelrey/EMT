package com.example.emtlab.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    @ManyToOne
    private Country country;
    @ManyToMany
    @JoinTable(
            name = "host_guests",
            joinColumns = @JoinColumn(name = "guest_id"),
            inverseJoinColumns = @JoinColumn(name = "host_id")
    )
    @JsonManagedReference
    private List<Host> hosts = new ArrayList<>();

    public Guest(String name, String surname, Country country) {
        this.name = name;
        this.surname = surname;
        this.country = country;
        this.hosts = new ArrayList<>();
    }

    public Guest() {
    }

    public Guest(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Country getCountry() {
        return country;
    }

    public List<Host> getHosts() {
        return hosts;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public void setHosts(List<Host> hosts) {
        this.hosts = hosts;
    }
}
