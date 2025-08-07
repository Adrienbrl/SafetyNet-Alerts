package com.safetynetalerts.safetynet_alerts.service;

import com.safetynetalerts.safetynet_alerts.dto.CoveredPersonDTO;
import com.safetynetalerts.safetynet_alerts.dto.FirestationCoverageDTO;
import com.safetynetalerts.safetynet_alerts.model.Person;
import com.safetynetalerts.safetynet_alerts.model.MedicalRecord;
import com.safetynetalerts.safetynet_alerts.repository.DataRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FirestationService {

    private final DataRepository dataRepository;

    public FirestationService(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    public FirestationCoverageDTO getPersonsCoveredByStation(int stationNumber) {

        List<String> addresses = dataRepository.getAddressesByStationNumber(stationNumber);
        List<Person> persons = dataRepository.getPersonsByAddresses(addresses);
        List<CoveredPersonDTO> coveredDTOs = new ArrayList<>();

        int adults = 0;
        int children = 0;

        for (Person person : persons) {
            Optional<MedicalRecord> recordOpt = dataRepository.getMedicalRecordByFirstAndLastName(
                    person.getFirstName(), person.getLastName()
            );

            if (recordOpt.isPresent()) {
                String birthdate = recordOpt.get().getBirthdate();
                int age = calculateAge(birthdate);

                if (age <= 18) {
                    children++;
                } else {
                    adults++;
                }

                coveredDTOs.add(new CoveredPersonDTO(
                        person.getFirstName(),
                        person.getLastName(),
                        person.getAddress(),
                        person.getPhone()
                ));
            }
        }

        return new FirestationCoverageDTO(coveredDTOs, adults, children);
    }

    private int calculateAge(String birthDateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate birthDate = LocalDate.parse(birthDateString, formatter);
        return Period.between(birthDate, LocalDate.now()).getYears();
    }
}


