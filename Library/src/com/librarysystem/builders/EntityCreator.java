package com.librarysystem.builders;
import com.librarysystem.entities.Borrower;
import com.librarysystem.entities.Item;
public interface EntityCreator {
    Borrower createBorrower(int id);
    Item createItem(int libraryId);
}
