package com.librarysystem.builders;
import com.librarysystem.entities.Item;

public interface ItemCreator {
    Item createItem(int libraryId, String title, String description);
}
