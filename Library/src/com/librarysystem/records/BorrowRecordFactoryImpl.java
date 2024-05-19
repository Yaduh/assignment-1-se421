package com.librarysystem.records;
import java.time.LocalDate;

import com.librarysystem.entities.Borrower;
import com.librarysystem.entities.Item;

public class BorrowRecordFactoryImpl implements BorrowRecordFactory {
    @Override
    public BorrowRecord create(Borrower borrower, Item item, LocalDate borrowDate) {
        return new BorrowRecord(borrower, item, borrowDate);
    }

}
