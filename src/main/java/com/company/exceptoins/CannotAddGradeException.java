package com.company.exceptoins;

public class CannotAddGradeException
        extends RuntimeException {
    public CannotAddGradeException(String subjectName) {
        super("Can't add grade to subject \""+ subjectName +'\"');
    }
}
