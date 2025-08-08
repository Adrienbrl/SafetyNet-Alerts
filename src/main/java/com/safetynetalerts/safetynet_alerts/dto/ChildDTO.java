package com.safetynetalerts.safetynet_alerts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChildDTO {
    private String firstName;
    private String lastName;
    private int age;
    private List<HouseholdMemberDTO> otherHouseholdMembers;
}




