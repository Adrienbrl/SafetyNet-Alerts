package com.safetynetalerts.safetynet_alerts.controller;

import com.safetynetalerts.safetynet_alerts.dto.FloodStationsResponseDTO;
import com.safetynetalerts.safetynet_alerts.service.FloodService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FloodController {

    private final FloodService floodService;

    public FloodController(FloodService floodService) {
        this.floodService = floodService;
    }

    @GetMapping("/flood/stations")
    public ResponseEntity<FloodStationsResponseDTO> getHouseholdsByStations(
            @RequestParam("stations") List<Integer> stations) {

        if (stations == null || stations.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        FloodStationsResponseDTO response = floodService.getHouseholdsByStations(stations);
        return ResponseEntity.ok(response);
    }
}

