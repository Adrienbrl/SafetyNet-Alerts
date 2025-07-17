package com.safetynet.alerts.dto;

import java.util.List;

public class FirestationCoverageDTO {
    List<CoveredPersonDTO> coveredPersons;
    PopulationCountDTO populationCount;

    public FirestationCoverageDTO() {}

    public FirestationCoverageDTO(List<CoveredPersonDTO> coveredPersons, PopulationCountDTO populationCount) {
        this.coveredPersons = coveredPersons;
        this.populationCount = populationCount;
    }

    public List<CoveredPersonDTO> getCoveredPersons() {
        return coveredPersons;
    }

    public void setCoveredPersons(List<CoveredPersonDTO> coveredPersons) {
        this.coveredPersons = coveredPersons;
    }

    public PopulationCountDTO getPopulationCount() {
        return populationCount;
    }

    public void setPopulationCount(PopulationCountDTO populationCount) {
        this.populationCount = populationCount;
    }
}
