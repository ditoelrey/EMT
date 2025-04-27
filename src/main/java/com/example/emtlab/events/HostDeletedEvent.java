package com.example.emtlab.events;

import com.example.emtlab.model.Host;

public class HostDeletedEvent {

    private final Long hostId;
    public HostDeletedEvent(Long hostId) {
        this.hostId = hostId;
    }
    public Long getHostId() {
        return hostId;
    }
}
