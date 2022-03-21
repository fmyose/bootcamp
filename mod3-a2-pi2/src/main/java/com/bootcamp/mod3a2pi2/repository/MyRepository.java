package com.bootcamp.mod3a2pi2.repository;

import java.util.List;

public interface MyRepository<T> {

    public T find(String s);

    public List<T> getAll();
}
