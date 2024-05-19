package com.librarysystem.main;
import java.time.LocalDate;

import com.librarysystem.entities.*;
import com.librarysystem.utilities.*;
import com.librarysystem.lists.*;



public interface LibrarySystemInterface {
    void addRecord(Borrower borrower, Item item, LocalDate borrowDate);
    void returnRecord(Borrower borrower, Item item);
    void displayBorrowRecords();
    void displayItemList(ListInterface<Item> itemList);
    void displayborrowerList(ListInterface<Borrower> borrowerList);
    void registerListener(LibraryListener listener);
}
