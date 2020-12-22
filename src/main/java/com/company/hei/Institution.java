package com.company.hei;

import com.company.ClassWithName;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public abstract class Institution extends ClassWithName {

    @Override
    public String enterName() throws IOException {
        return this.enterName("Please enter the name:", "[a-zA-Z_0-9\\s]+");
    }

    protected boolean getList(List col, String name) {
        col.sort(this.NameComparator);
        if(col.isEmpty()) {
            System.out.println("The list of " + name + " is empty.");
            return false;
        } else {
            System.out.println("The list of " + name + ':');
            Iterator<ClassWithName> iter = col.iterator();
            for(int i = 1; iter.hasNext(); i++){
                System.out.println(i + ". " + iter.next().getName());
            }
            return true;
        }
    }

    protected Object getOne(Collection<? extends ClassWithName> col, String name, int i) {
        if (col.isEmpty()) {
            System.out.println("The list of " + name + " is empty.");
            return null;
        } else if (i < 0 || i > col.size()) {
            System.out.println("You've entered a wrong number.");
            return null;
        }
        return col.toArray()[i];
    }


}
