package com.example.emtlab.events;

import com.example.emtlab.model.Host;

public class HostUpdatedEvent {

    private final Host host;
    public HostUpdatedEvent(Host host) {
        this.host = host;
    }
    public Host getHost() {
        return host;
    }
}
