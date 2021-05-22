package com.company.domain.hei;

import com.company.exceptoins.EmptyListException;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "faculties")
public class Faculty extends Institution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "name", nullable = false)
    protected String name;

    @OneToMany(mappedBy = "faculty")
    private List<Department> departments = new ArrayList<>();

//    public Faculty() throws IOException {
//        this.name = this.enterName();
//    }
    public Faculty() { }

    public Faculty(String name) {
        this.name = name;
    }

    private boolean lookUp(final String obName) {
        return departments.stream().anyMatch(o -> o.getName().equals(obName));
    }

    public boolean addDepartment(Department department) {
        if (department == null) {
            throw new IllegalArgumentException("department must not be null");
        }
        if(lookUp(department.getName())) {
//            System.out.println("This faculty already has this department ");
            return false;
        } else {
            departments.add(department);
            return true;
        }
    }

//    public boolean addDepartment() throws IOException {
//        return addDepartment(new Department());
//    }

    public boolean showDepartmentList() {
        return showList(departments, "departments");
    }

    public Department getDepartment(int i) throws EmptyListException {
        return (Department) getOne(departments, "departments", i);
    }

    @Override
    public String toString() {
        return id + " " + name;
    }

    @Override
        public int hashCode() {
        return name.hashCode() + departments.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this.hashCode() != obj.hashCode()) {
            return false;
        }
        if (obj instanceof Faculty) {
            Faculty anobj = (Faculty)obj;
            return this.name.equals(anobj.name) & this.departments.equals(anobj.departments);
        }
        return false;
    }
}
