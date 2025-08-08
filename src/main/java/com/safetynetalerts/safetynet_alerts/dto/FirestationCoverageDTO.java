package com.safetynetalerts.safetynet_alerts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class FirestationCoverageDTO {
    private List<CoveredPersonDTO> coveredPersons;
    private int numberOfAdults;
    private int numberOfChildren;
}

