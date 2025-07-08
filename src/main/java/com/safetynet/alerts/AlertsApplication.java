package com.safetynet.alerts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.safetynet.alerts.model.DataWrapper;
import com.safetynet.alerts.service.JsonDataReader;

@SpringBootApplication
public class AlertsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlertsApplication.class, args);

		String filePath = "src/main/resources/data.json";
		DataWrapper data = JsonDataReader.readData(filePath);

		if (data != null) {
			System.out.println("Nombre de personnes : " + data.getPersons().size());
			System.out.println("Nombre de casernes : " + data.getFirestations().size());
			System.out.println("Nombre de dossiers médicaux : " + data.getMedicalrecords().size());
		} else {
			System.out.println("Erreur lors du parsing du fichier JSON.");
		}
	}
}


