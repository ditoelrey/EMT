package com.example.emtlab.listeners;


import com.example.emtlab.events.HostCreatedEvent;
import com.example.emtlab.events.HostDeletedEvent;
import com.example.emtlab.events.HostUpdatedEvent;
import com.example.emtlab.service.domain.HostService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class HostsByCountryEventHandlers {

    private final HostService hostService;

    public HostsByCountryEventHandlers(HostService hostService) {
        this.hostService = hostService;
    }

    @EventListener
    public void onHostCreated(HostCreatedEvent event) {
        this.hostService.refreshMaterializedView();
    }

    @EventListener
    public void onHostUpdated(HostUpdatedEvent event) {
        this.hostService.refreshMaterializedView();
    }

    @EventListener
    public void onHostDeleted(HostDeletedEvent event) {
        this.hostService.refreshMaterializedView();
    }

}
