package com.safetynet.alerts.dto;

public class PopulationCountDTO {
    int numberOfAdults;
    int numberOfChildren;

    public PopulationCountDTO() {}

    public PopulationCountDTO(int numberOfAdults, int numberOfChildren) {
        this.numberOfAdults = numberOfAdults;
        this.numberOfChildren = numberOfChildren;
    }

    public int getNumberOfAdults() {
        return numberOfAdults;
    }

    public void setNumberOfAdults(int numberOfAdults) {
        this.numberOfAdults = numberOfAdults;
    }

    public int getNumberOfChildren() {
        return numberOfChildren;
    }

    public void setNumberOfChildren(int numberOfChildren) {
        this.numberOfChildren = numberOfChildren;
    }
}
