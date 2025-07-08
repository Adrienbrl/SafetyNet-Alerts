package com.safetynet.alerts.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.safetynet.alerts.model.DataWrapper;

import java.io.FileReader;
import java.io.IOException;

public class JsonDataReader {

    public static DataWrapper readData(String filePath){
        Gson gson = new GsonBuilder().create();

        try (FileReader reader = new FileReader(filePath)){
            return gson.fromJson(reader, DataWrapper.class);
        } catch (IOException e){
            System.err.println("Erreur lors de la lecture du fichier JSON : " + e.getMessage());
            return null;
        }
    }
}
