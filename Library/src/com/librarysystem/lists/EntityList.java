package com.librarysystem.lists;

import java.util.List;

public interface EntityList<Entity> {
    void addEntity(Entity entity);
    void removeEntity(Entity entity);
    Entity getEntityById(int id);
    List<Entity> getEntityList();
}