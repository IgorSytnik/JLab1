package com.company.services.interfaces;

import com.company.domain.inanimate.subject.Grade;

import java.util.Collection;

public interface Common<E> {
    E make(E ob);
    Collection<E> makeMany(Collection<E> collection);
    Collection<E> getAll();
    E findById(long id);
}
