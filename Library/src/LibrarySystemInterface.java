import java.time.LocalDate;

public interface LibrarySystemInterface {
    void addRecord(Borrower borrower, Item item, LocalDate borrowDate);
    void returnRecord(Borrower borrower, Item item);
    void displayBorrowRecords();
    void displayItemList(ListInterface<Item> itemList);
    void displayborrowerList(ListInterface<Borrower> borrowerList);
}
