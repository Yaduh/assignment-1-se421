package com.librarysystem.lists;

import java.util.List;

public interface EntityList<T> {
    void addEntity(T entity);
    void removeEntity(T entity);
    T getEntityById(int id);
    List<T> getEntityList();
}