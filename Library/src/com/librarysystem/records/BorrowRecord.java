package com.librarysystem.records;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import com.google.inject.Inject;
import com.librarysystem.entities.*;

public class BorrowRecord {
    private final Borrower borrower;
    private final Item item;
    private double fine;
    private final LocalDate borrowDate;
    private final LocalDate dueDate;
    
    @Inject
    public BorrowRecord(Borrower borrower, Item item, LocalDate borrowDate) {
        this.borrower = borrower;
        this.item = item;
        this.borrowDate = borrowDate;
        this.dueDate = borrowDate.plusWeeks(2);  
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public Borrower getBorrower() {
        return this.borrower;
    }

    public Item getItem() {
        return this.item;
    }

    public double getFine() {
        return this.fine;
    }

    public void setFine(double fine) {
        this.fine = fine;
    }

    public long getOverdueDays() {
        if (LocalDate.now().isAfter(dueDate)) {
            return ChronoUnit.DAYS.between(dueDate, LocalDate.now()); // assuming record is returned now
        }
        return 0;
    }

    public boolean isOverdue() {
        return LocalDate.now().isAfter(dueDate);
    }

    public void updateFine(double fineRate) {
        long overdueDays = getOverdueDays();
        if (overdueDays > 0) {
            setFine(overdueDays * fineRate);
        }
    }
}
