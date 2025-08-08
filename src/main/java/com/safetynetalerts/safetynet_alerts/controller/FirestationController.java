package com.safetynetalerts.safetynet_alerts.controller;

import com.safetynetalerts.safetynet_alerts.dto.FirestationCoverageDTO;
import com.safetynetalerts.safetynet_alerts.service.FirestationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/firestation")
public class FirestationController {

    private final FirestationService firestationService;

    public FirestationController(FirestationService firestationService) {
        this.firestationService = firestationService;
    }

    @GetMapping
    public FirestationCoverageDTO getPersonsByStation(@RequestParam int stationNumber) {
        return firestationService.getPersonsCoveredByStation(stationNumber);
    }
}


