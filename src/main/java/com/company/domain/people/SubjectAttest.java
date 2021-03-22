package com.company.domain.people;

import com.company.exceptoins.AttestationException;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class SubjectAttest {

    final Map<Date,Integer> grades = new HashMap<>();
    final boolean[] attestations = new boolean[2];
    int attestationCount = 0;
    public void addGrade(Date date, int grade) {
        grades.put(date, grade);
    }
    
    public int getAttestationCount() {
        return attestationCount;
    }

    public void addGradesAsMap(Map<Date,Integer> grades) {
        this.grades.putAll(grades);
    }

    public void addAttestation(boolean attest) {
        if (attestations.length >= attestationCount)
            throw new AttestationException("Can't add attestation to subject");
        attestations[attestationCount++] = attest;
    }

    public Map<Date, Integer> getGrades() {
        return grades;
    }

    public boolean[] getAttestations() {
        return attestations;
    }


}
