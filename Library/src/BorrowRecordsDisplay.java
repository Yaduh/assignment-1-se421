class BorrowRecordsDisplay implements LibraryListener {
    private LibrarySystemInterface librarySystem;

    public BorrowRecordsDisplay(LibrarySystemInterface librarySystem) {
        this.librarySystem = librarySystem;
    }

    @Override
    public void onUpdate() {
        librarySystem.displayBorrowRecords();
    }
}
