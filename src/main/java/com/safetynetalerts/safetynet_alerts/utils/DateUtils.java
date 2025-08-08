package com.safetynetalerts.safetynet_alerts.utils;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    public static int calculateAge(String birthDateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate birthDate = LocalDate.parse(birthDateString, formatter);
        return Period.between(birthDate, LocalDate.now()).getYears();
    }
}

