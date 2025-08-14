package com.safetynetalerts.safetynet_alerts.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({ "stationNumbers", "residents" })
public class FireAddressResponseDTO {
    private List<Integer> stationNumbers = new ArrayList<>();
    private List<FireResidentDTO> residents = new ArrayList<>();
}


