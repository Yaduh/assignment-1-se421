package com.librarysystem.records;
import java.time.LocalDate;

import com.librarysystem.entities.*;

public interface BorrowRecordFactory {
    BorrowRecord create(Borrower borrower, Item item, LocalDate borrowDate);
}

