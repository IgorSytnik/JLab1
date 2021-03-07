package com.company.hei;

import com.company.exceptoins.EmptyListException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HigherEducationalInstitution extends Institution {
    private List<Faculty> faculties = new ArrayList<>();

    public HigherEducationalInstitution() throws IOException {
        this.name = this.enterName();
    }
    public HigherEducationalInstitution(String n) {
        this.name = n;
    }

    private boolean lookUp(final String obName) {
        return faculties.stream().anyMatch(o -> o.getName().equals(obName));
    }

    public boolean addFaculty() throws IOException {
        Faculty faculty = new Faculty();
        if(lookUp(faculty.getName())) {
            System.out.println("This institution already has this faculty ");
            return false;
        } else {
            faculties.add(faculty);
            return true;
        }
    }

//    public void addDepartment() throws IOException {
//        if(getFacList()) {
//            System.out.println("\nWhere do you want to put new department? (pick the faculty)");
//            int num = Input.inputInt("Please enter the number from the list (-1 to cancel):",
//                    1,
//                    faculties.size()) - 1;
//            if(num == -1) return;
//            faculties.get(num).addDepartment();
//        } else {
//            System.out.println("\nFirst, you need to add faculties.");
//        }
//    }

    public boolean showFacList() {
        return showList(faculties, "faculties");
    }

    public Faculty getFaculty(int i) throws EmptyListException {
        Object obj = getOne(faculties, "faculties", i);
        return (Faculty) obj;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + faculties.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this.hashCode() != obj.hashCode()) {
            return false;
        }
        if (obj instanceof HigherEducationalInstitution) {
            HigherEducationalInstitution anobj = (HigherEducationalInstitution)obj;
            return this.name.equals(anobj.name) & this.faculties.equals(anobj.faculties);
        }
        return false;
    }
}
