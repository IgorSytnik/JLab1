package com.company.domain.people;

import com.company.domain.ClassWithName;

public class Teacher extends ClassWithName {

    private long id;
    private AcademicPosition position;

//    public Teacher() throws IOException {
//        this.name = this.enterName();
//        AcademicPosition[] val = AcademicPosition.values();
//        this.position = val[Input.inputInt(
//                AcademicPosition.list() + "\nPlease enter the number of teacher's position from the list above:"
//                , 1
//                , val.length
//                ) - 1];
//    }

    public Teacher(String name, AcademicPosition position) {
        this.name = name;
        this.position = position;
    }

    /**
     * Get teachers position
     * @return enum element of AcademicPosition */
    public AcademicPosition getPosition() { return position; }

    /**
     * Example:
     * David Newberg, position: Aspirant */
    @Override
    public String toString() {
        return name + ", position: " + position;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + position.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this.hashCode() != obj.hashCode()) {
            return false;
        }
        if (obj instanceof Teacher) {
            Teacher anobj = (Teacher)obj;
            return this.name.equals(anobj.name)
                    & this.position.equals(anobj.position);
        }
        return false;
    }
}
