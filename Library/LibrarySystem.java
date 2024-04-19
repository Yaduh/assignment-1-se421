package Library;
import java.time.LocalDate;
import java.time.Duration;
import java.util.HashMap;

class LibrarySystem {
    private FineCalculator calculator = new FineCalculator();
    private HashMap<Integer,BorrowRecord> records = new HashMap<>();

    public void addRecord(Borrower borrower, Item item, LocalDate borrowDate) {
        BorrowRecord newRecord = new BorrowRecord(borrower, item, borrowDate);
        // Check if borrower is at the borrow limit
        if (borrower.getBorrowed() >= borrower.getBorrowLimit()) {
            System.out.println("Recipient is at the borrow limit.");
            return; 
        }
        borrower.incrementBorrowed();
        this.records.put(item.getId(), newRecord);
        System.out.println(borrower.getBorrowed());
        displayBorrowRecords();
    }

    public void returnRecord(Borrower borrower, Item item, LocalDate returnDate){
        BorrowRecord recordToReturn = this.records.get(item.getId());
            if (recordToReturn != null) {
                long daysLate = Duration.between(recordToReturn.getDueDate().atStartOfDay(), returnDate.atStartOfDay()).toDays();
                
               // fine calculation
                recordToReturn.setFine(calculator.calculateFine(recordToReturn.getItem(), daysLate));
                System.out.println("Item returned successfully.");
                displayBorrowRecords();
                this.records.remove(item.getId());
                borrower.decrementBorrowed();
            } else {
                System.out.println("No matching lend record found.");
            }
            
    }
    
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
    
    
    
    
    
    
}
