package com.safetynetalerts.safetynet_alerts.utils;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 * Classe utilitaire pour la gestion et le calcul des dates.
 * Fournit une méthode pour calculer l'âge d'une personne à partir de sa date de naissance.
 */
public class DateUtils {

    /**
     * Calcule l'âge en années complètes à partir d'une date de naissance fournie
     * sous forme de chaîne de caractères au format "MM/dd/yyyy".
     *
     * @param birthDateString La date de naissance sous forme de chaîne.
     * @return L'âge en années complètes.
     */
    public static int calculateAge(String birthDateString) {
        // Définit le format attendu pour la date (mois/jour/année)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        // Convertit la chaîne de date en objet LocalDate en utilisant le format défini
        LocalDate birthDate = LocalDate.parse(birthDateString, formatter);
        // Calcule la différence en années entre la date de naissance et la date actuelle
        return Period.between(birthDate, LocalDate.now()).getYears();
    }
}

