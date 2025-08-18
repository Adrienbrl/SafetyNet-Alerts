package com.safetynetalerts.safetynet_alerts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HouseholdDTO {
    private String address;
    private List<FireResidentDTO> residents;
}

