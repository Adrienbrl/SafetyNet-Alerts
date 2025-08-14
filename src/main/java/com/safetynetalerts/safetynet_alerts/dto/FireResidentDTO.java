package com.safetynetalerts.safetynet_alerts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FireResidentDTO {
    private String firstName;
    private String lastName;
    private String phone;
    private Integer age;
    private List<String> medications = new ArrayList<>();
    private List<String> allergies = new ArrayList<>();
}

