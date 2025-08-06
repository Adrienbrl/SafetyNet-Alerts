package com.safetynetalerts.safetynet_alerts.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.safetynetalerts.safetynet_alerts.dto.DataContainer;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

@Service
public class JsonDataLoader {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private DataContainer dataContainer;

    @PostConstruct
    public void init() {
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("data.json")) {
            if (is == null) {
                throw new RuntimeException("Le fichier data.json est introuvable dans le dossier resources !");
            }
            dataContainer = objectMapper.readValue(is, DataContainer.class);
        } catch (IOException e) {
            throw new RuntimeException("Erreur lors du parsing du fichier JSON", e);
        }
    }

    public DataContainer getData() {
        return dataContainer;
    }
}
