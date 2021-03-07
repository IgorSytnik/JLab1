package com.company.hei;

import com.company.ClassWithName;
import com.company.exceptoins.EmptyListException;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public abstract class Institution extends ClassWithName {

    // TODO Institution Throw it to view or something
    @Override
    public String enterName() throws IOException {
        return this.enterName("Please enter the name:", "[a-zA-Z_0-9\\s]+");
    }

    // Do I need this method at all?
    protected boolean showList(List col, String name) {
        col.sort(this.NameComparator);
        if(col.isEmpty()) {
            // TODO Institution.showList Throw ex "The list of " + name + " is empty." EmptyListEx??
            System.out.println("The list of " + name + " is empty.");
            return false;
        } else {
            // TODO Institution.showList Return String ?
            System.out.println("The list of " + name + ':');
            Iterator<ClassWithName> iter = col.iterator();
            for(int i = 1; iter.hasNext(); i++){
                System.out.println(i + ". " + iter.next().getName());
            }
            return true;
        }
    }

    protected Object getOne(Collection<? extends ClassWithName> col, String name, int index) throws EmptyListException {
        if (col.isEmpty()) {
            throw new EmptyListException(name);
        } else if (index < 0 || index > col.size()) {
            throw new IndexOutOfBoundsException(index);
        }
        return col.toArray()[index];
    }


}
