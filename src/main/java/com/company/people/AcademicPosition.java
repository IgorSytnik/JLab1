package com.company.people;

public enum AcademicPosition {
    ASPIRANT("Aspirant"),
    ASSISTANT("Assistant"),
    LEADING_RESEARCHER("Leading researcher"),
    PRINCIPAL_RESEARCHER("Principal researcher"),
    DOCTORAL_STUDENT("Doctoral student"),
    DOCENT("Docent"),
    JUNIOR_RESEARCHER("Junior researcher"),
    RESEARCHER("Researcher"),
    LECTURER("Lecturer"),
    PROFESSOR("Professor"),
    SENIOR_LECTURER("Senior lecturer"),
    TRAINEE("Trainee"),
    SENIOR_RESEARCHER("Senior researcher");

    private final String show;

    AcademicPosition(String sh) {
        this.show = sh;
    }

    public static String list() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < values().length; i++) {
            str.append(i+1);
            str.append(' ');
            str.append(values()[i]);
            str.append('\n');
        }
        return str.toString();
    }

    @Override
    public String toString() {
        return this.show;
    }
}
