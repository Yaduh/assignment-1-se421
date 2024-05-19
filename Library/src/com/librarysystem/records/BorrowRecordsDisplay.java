package com.librarysystem.records;
import com.librarysystem.main.LibrarySystemInterface;
import com.librarysystem.utilities.LibraryListener;

public class BorrowRecordsDisplay implements LibraryListener {
    private final LibrarySystemInterface librarySystem;

    public BorrowRecordsDisplay(LibrarySystemInterface librarySystem) {
        this.librarySystem = librarySystem;
    }

    @Override
    public void onUpdate() {
        librarySystem.displayBorrowRecords();
    }
}
