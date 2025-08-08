package com.safetynetalerts.safetynet_alerts.service;

import com.safetynetalerts.safetynet_alerts.dto.ChildDTO;
import com.safetynetalerts.safetynet_alerts.dto.HouseholdMemberDTO;
import com.safetynetalerts.safetynet_alerts.model.Person;
import com.safetynetalerts.safetynet_alerts.model.MedicalRecord;
import com.safetynetalerts.safetynet_alerts.repository.DataRepository;
import com.safetynetalerts.safetynet_alerts.utils.DateUtils;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ChildAlertService {

    private final DataRepository dataRepository;

    public ChildAlertService(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    public List<ChildDTO> getChildrenByAddress(String address) {
        List<Person> persons = dataRepository.getPersonsByAddress(address);
        List<ChildDTO> children = new ArrayList<>();

        for (Person person : persons) {
            Optional<MedicalRecord> recordOpt = dataRepository
                    .getMedicalRecordByFirstAndLastName(person.getFirstName(), person.getLastName());

            if (recordOpt.isPresent()) {
                int age = DateUtils.calculateAge(recordOpt.get().getBirthdate());

                if (age <= 18) {
                    List<HouseholdMemberDTO> otherMembers = persons.stream()
                            .filter(p -> !(p.getFirstName().equals(person.getFirstName()) &&
                                    p.getLastName().equals(person.getLastName())))
                            .map(p -> new HouseholdMemberDTO(p.getFirstName(), p.getLastName()))
                            .collect(Collectors.toList());

                    children.add(new ChildDTO(
                            person.getFirstName(),
                            person.getLastName(),
                            age,
                            otherMembers
                    ));
                }
            }
        }

        return children;
    }
}
