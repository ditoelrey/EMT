package com.example.emtlab.events;

import com.example.emtlab.model.Host;

public class HostCreatedEvent {

    private final Host host;
    public HostCreatedEvent(Host host) {
        this.host = host;
    }
    public Host getHost() {
        return host;
    }
}
