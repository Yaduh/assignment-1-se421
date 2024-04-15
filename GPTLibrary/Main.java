package GPTLibrary;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        LibraryItem book = new LibraryItem(1, "The Great Gatsby", "Classic novel by F. Scott Fitzgerald");
        LibraryManager libraryManager = new LibraryManager();
        libraryManager.lendItem(book, 12345, LocalDate.now());
        libraryManager.returnItem(book, 12345, LocalDate.now().plusDays(15));
    }
}
