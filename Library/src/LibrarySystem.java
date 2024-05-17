
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.google.inject.Inject;

class LibrarySystem implements LibrarySystemInterface {
    private final FineCalculatorInterface fineCalculator;
    private BorrowRecordFactory borrowRecordFactory;
    private List<LibraryListener> listeners = new ArrayList<>();

    private HashMap<Integer,BorrowRecord> records = new HashMap<>();

    @Inject
    public LibrarySystem(BorrowRecordFactory borrowRecordFactory, FineCalculatorInterface fineCalculator) {
        this.borrowRecordFactory = borrowRecordFactory;
        this.fineCalculator = fineCalculator;
    }

    @Override
    public void registerListener(LibraryListener listener) {
        listeners.add(listener);
    }

    private void notifyListeners() {
        listeners.forEach(LibraryListener::onUpdate);
    }

    @Override
    public void addRecord(Borrower borrower, Item item, LocalDate borrowDate) {
        if (borrower.getBorrowed() >= borrower.getBorrowLimit()) {
            System.out.println("Recipient is at the borrow limit.");
            return;
        }
        BorrowRecord newRecord = borrowRecordFactory.create(borrower, item, borrowDate);
        borrower.incrementBorrowed();
        this.records.put(item.getId(), newRecord);
        notifyListeners();
    }

    @Override
    public void returnRecord(Borrower borrower, Item item) {
        BorrowRecord recordToReturn = this.records.get(item.getId());
        if (recordToReturn != null) {
            recordToReturn.setFine(fineCalculator.calculateFine(recordToReturn));
            System.out.println("Item returned successfully.");
            borrower.decrementBorrowed();
            notifyListeners();
            this.records.remove(item.getId());
        } else {
            System.out.println("No matching lend record found.");
        }
    }

    @Override
    public void displayBorrowRecords() {
        System.out.println("Lend Records:");
        System.out.println("--------------------------------------------------------");
        System.out.println("Borrower      | ID       | Item    | Library ID | Due Date | Fine");
        System.out.println("--------------------------------------------------------");
        records.forEach((key, value) -> {
            Borrower b = value.getBorrower();
            Item i = value.getItem();
            double fine = value.getFine();
            
            // Set color based on the fine amount
            String color = fine > 0 ? "\u001B[31m" : "\u001B[0m"; // 001B[31m sets the color to Red for positive fine, 001B[0 sets the color to default for zero or negative fine
            
            System.out.printf("%s%-14s | %-10s | %-8s | %-11s | %-9s| -$%.2f\u001B[0m%n",
                color,
                b.getBorrowerType(), 
                b.getId(),
                i.getItemType(), 
                i.getId(), 
                value.getDueDate(), 
                fine);
        });
        System.out.println("--------------------------------------------------------");
    }
    @Override
    public void displayItemList(ListInterface<Item> itemList) {
        System.out.println("---------------------------------------------------");
        System.out.println("ID | Type              | Title              | Description          | Fine Per Day");
        System.out.println("---------------------------------------------------");
        for (Item item : itemList.getEntityList()) {
            System.out.printf("%-3d| %-18s| %-20s| %-20s| %.2f%n",
                item.getId(),
                item.getItemType(),
                item.getTitle(),
                item.getDescription(),
                item.getFinePerDay());
        }
        System.out.println("---------------------------------------------------");
    }
    @Override
    public void displayborrowerList(ListInterface<Borrower> borrowerList) {
        System.out.println("---------------------------------------------------");
        System.out.println("ID | Type              | Ammount of Items Borrowed");
        System.out.println("---------------------------------------------------");
        for (Borrower borrower : borrowerList.getEntityList()) {
            System.out.printf("%-3d| %-9s| %-2s%n",
                borrower.getId(),
                borrower.getBorrowerType(),
                borrower.getBorrowed());
        }
        System.out.println("---------------------------------------------------");
    }


    
    
    
    
    
}
