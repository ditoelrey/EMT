package com.example.emtlab.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Reservation {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Accommodation accommodation;

    private boolean confirmed;

    public Reservation() {
    }

    public Reservation(Long id, User user, Accommodation accommodation, boolean confirmed) {
        this.id = id;
        this.user = user;
        this.accommodation = accommodation;
        this.confirmed = confirmed;
    }

    public Reservation(User user, Accommodation accommodation, boolean confirmed) {
        this.user = user;
        this.accommodation = accommodation;
        this.confirmed = confirmed;
    }


    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Accommodation getAccommodation() {
        return accommodation;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setAccommodation(Accommodation accommodation) {
        this.accommodation = accommodation;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }
}
