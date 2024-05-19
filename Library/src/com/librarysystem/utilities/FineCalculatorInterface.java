package com.librarysystem.utilities;
import com.librarysystem.records.BorrowRecord;

public interface FineCalculatorInterface {
    double calculateFine(BorrowRecord record);
}
