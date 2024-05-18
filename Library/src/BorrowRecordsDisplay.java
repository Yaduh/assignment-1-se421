class BorrowRecordsDisplay implements LibraryListener {
    private final LibrarySystemInterface librarySystem;

    public BorrowRecordsDisplay(LibrarySystemInterface librarySystem) {
        this.librarySystem = librarySystem;
    }

    @Override
    public void onUpdate() {
        librarySystem.displayBorrowRecords();
    }
}
