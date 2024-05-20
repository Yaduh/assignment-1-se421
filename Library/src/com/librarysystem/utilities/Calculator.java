package com.librarysystem.utilities;
import com.librarysystem.records.BorrowRecord;

public interface Calculator {
    double calculateFine(BorrowRecord record);
}
