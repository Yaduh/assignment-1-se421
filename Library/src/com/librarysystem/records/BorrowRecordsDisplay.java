package com.librarysystem.records;
import com.librarysystem.main.LibraryService;
import com.librarysystem.utilities.LibraryListener;

public class BorrowRecordsDisplay implements LibraryListener {
    private final LibraryService librarySystem;

    public BorrowRecordsDisplay(LibraryService librarySystem) {
        this.librarySystem = librarySystem;
    }

    @Override
    public void onUpdate() {
        librarySystem.displayBorrowRecords();
    }
}
