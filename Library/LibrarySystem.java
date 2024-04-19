package Library;
import java.time.LocalDate;
import java.time.Duration;
import java.util.HashMap;

class LibrarySystem {
    private FineCalculator calculator = new FineCalculator();
    private HashMap<Integer,LendRecord> records = new HashMap<>();

    public void addRecord(Borrower borrower,Item item, LocalDate borrowDate){
        LendRecord newRecord = new LendRecord(borrower,item, borrowDate);
        this.records.put(item.getId(), newRecord);
        displayBorrowRecords();
    }

    public void returnRecord(int itemId, LocalDate returnDate){
        LendRecord recordToReturn = null;
                recordToReturn = this.records.get(itemId);
            if (recordToReturn != null) {
                long daysLate = Duration.between(recordToReturn.getDueDate().atStartOfDay(), returnDate.atStartOfDay()).toDays();
                
               // fine calculation
                recordToReturn.setFine(calculator.calculateFine(recordToReturn.getItem(), daysLate));
                System.out.println("Item returned successfully.");
                System.out.println(daysLate);
                displayBorrowRecords();
                this.records.remove(itemId);
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
            
            System.out.printf("%-14s | %-10s | %-8s | %-11s | %-9s| -$%.2f%n",
                b.getBorrowerType(), 
                b.getId(),
                i.getItemType(), 
                i.getId(), 
                value.getDueDate(), 
                value.getFine());
        });
        System.out.println("--------------------------------------------------------");
    }
    
    
    
    
    
}
