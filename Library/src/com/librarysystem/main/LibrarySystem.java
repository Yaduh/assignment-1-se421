package com.librarysystem.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.librarysystem.entities.*;
import com.librarysystem.utilities.*;
import com.librarysystem.lists.*;
import com.librarysystem.records.*;

@Singleton
public class LibrarySystem implements LibraryService {
    private final Calculator fineCalculator;
    private final BorrowRecordFactory borrowRecordFactory;
    private final List<LibraryListener> listeners;
    private final HashMap<Integer, BorrowRecord> records;

    @Inject
    public LibrarySystem(Calculator fineCalculator, BorrowRecordFactory borrowRecordFactory) {
        this.fineCalculator = fineCalculator;
        this.borrowRecordFactory = borrowRecordFactory;
        this.listeners = new ArrayList<>();
        this.records = new HashMap<>();
    }

    @Override
    public void registerListener(LibraryListener listener) {
        listeners.add(listener);
    }

    private void notifyListeners() {
        for(LibraryListener l : listeners){
            l.onUpdate();
        }
    }

    @Override
    public void addRecord(Borrower borrower, Item item, LocalDate borrowDate) {
        if (borrower.getBorrowed() >= borrower.getBorrowLimit()) {
            System.out.println("Recipient is at the borrow limit.");
            return;
        }
        BorrowRecord newRecord = borrowRecordFactory.create(borrower, item, borrowDate);
        borrower.incrementBorrowed();
        records.put(item.getId(), newRecord);
        notifyListeners();
    }

    @Override
    public void returnRecord(Borrower borrower, Item item) {
        BorrowRecord recordToReturn = records.get(item.getId());
        if (recordToReturn != null) {
            recordToReturn.setFine(fineCalculator.calculateFine(recordToReturn));
            System.out.println("Item returned successfully.");
            borrower.decrementBorrowed();
            notifyListeners();
            records.remove(item.getId());
        } else {
            System.out.println("No matching lend record found.");
        }
    }

    @Override
    public void displayBorrowRecords() {
        System.out.println("Lend Records:");
        System.out.println("--------------------------------------------------------");
        System.out.println("Borrower      | ID       | Item    | Library ID | Due Date | Fine");
        System.out.println("--------------------------------------------------------");
        records.forEach((key, value) -> {
            Borrower b = value.getBorrower();
            Item i = value.getItem();
            double fine = value.getFine();
            
            // Set color based on the fine amount
            String color = fine > 0 ? "\u001B[31m" : "\u001B[0m"; // 001B[31m sets the color to Red for positive fine, 001B[0 sets the color to default for zero or negative fine
            
            System.out.printf("%s%-14s | %-10s | %-8s | %-11s | %-9s| -$%.2f\u001B[0m%n",
                color,
                b.getBorrowerType(), 
                b.getId(),
                i.getItemType(), 
                i.getId(), 
                value.getDueDate(), 
                fine);
        });
        System.out.println("--------------------------------------------------------");
    }
    @Override
    public void displayItemList(EntityList<Item> itemList) {
        System.out.println("---------------------------------------------------");
        System.out.println("ID | Type              | Title              | Description          | Fine Per Day");
        System.out.println("---------------------------------------------------");
        for (Item item : itemList.getEntityList()) {
            System.out.printf("%-3d| %-18s| %-20s| %-20s| %.2f%n",
                item.getId(),
                item.getItemType(),
                item.getTitle(),
                item.getDescription(),
                item.getFinePerDay());
        }
        System.out.println("---------------------------------------------------");
    }
    @Override
    public void displayborrowerList(EntityList<Borrower> borrowerList) {
        System.out.println("---------------------------------------------------");
        System.out.println("ID | Type              | Ammount of Items Borrowed");
        System.out.println("---------------------------------------------------");
        for (Borrower borrower : borrowerList.getEntityList()) {
            System.out.printf("%-3d| %-9s| %-2s%n",
                borrower.getId(),
                borrower.getBorrowerType(),
                borrower.getBorrowed());
        }
        System.out.println("---------------------------------------------------");
    }


    
    
    
    
    
}
