package com.example.emtlab.model;

import com.example.emtlab.model.enumerations.Category;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Accommodation {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    private Host host;
    private Integer numRooms;
    @Enumerated(EnumType.STRING)
    private Category category;

    public Accommodation() {
    }

    public Accommodation(String name, Host host, Integer numRooms, Category category) {
        this.name = name;
        this.host = host;
        this.numRooms = numRooms;
        this.category = category;
    }

    public Accommodation(String name, Integer numRooms, Category category) {
        this.name = name;
        this.numRooms = numRooms;
        this.category = category;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Host getHost() {
        return host;
    }

    public Integer getNumRooms() {
        return numRooms;
    }

    public Category getCategory() {
        return category;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHost(Host host) {
        this.host = host;
    }

    public void setNumRooms(Integer numRooms) {
        this.numRooms = numRooms;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
