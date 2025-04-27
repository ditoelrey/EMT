package com.example.emtlab.jobs;


import com.example.emtlab.service.domain.AccommodationService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

    private final AccommodationService accommodationService;

    public ScheduledTasks(AccommodationService accommodationService) {
        this.accommodationService = accommodationService;
    }

    @Scheduled(cron = "0 0 0 * * ?")  // Runs at midnight every day
    public void refreshAccommodationsByHostMaterializedView() {
        this.accommodationService.refreshAccommodationsByHostMaterializedView();
    }
}
