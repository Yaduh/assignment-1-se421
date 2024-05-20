package com.librarysystem.utilities;
import com.librarysystem.records.BorrowRecord;

public class FineCalculator implements Calculator {

        @Override
        public double calculateFine(BorrowRecord record) {
            if (record.isOverdue()) {
                double fineRate = record.getItem().getFinePerDay();
                record.updateFine(fineRate);
                return record.getFine();
                
            }
            return 0;
        }
    }
