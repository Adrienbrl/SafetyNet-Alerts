package com.safetynetalerts.safetynet_alerts.repository;

import com.safetynetalerts.safetynet_alerts.model.Person;
import com.safetynetalerts.safetynet_alerts.model.Firestation;
import com.safetynetalerts.safetynet_alerts.model.MedicalRecord;
import com.safetynetalerts.safetynet_alerts.service.JsonDataLoader;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class DataRepository {
    private final JsonDataLoader jsonDataLoader;

    private List<Person> persons;
    private List<Firestation> firestations;
    private List<MedicalRecord> medicalRecords;

    public DataRepository(JsonDataLoader jsonDataLoader) {
        this.jsonDataLoader = jsonDataLoader;
    }

    @PostConstruct
    public void init() {
        this.persons = new ArrayList<>(jsonDataLoader.getData().getPersons());
        this.firestations = new ArrayList<>(jsonDataLoader.getData().getFirestations());
        this.medicalRecords = new ArrayList<>(jsonDataLoader.getData().getMedicalrecords());
    }
}


