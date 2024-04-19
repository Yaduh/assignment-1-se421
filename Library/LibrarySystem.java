package Library;
import java.util.HashMap;

class LibrarySystem {
    private HashMap<Integer,BorrowRecord> records = new HashMap<>();
    public BorrowRecord getRecord(int itemId){
        return this.records.get(itemId);
    }

    public void addRecord(Borrower borrower,Item item){
        BorrowRecord newRecord = new BorrowRecord(borrower,item);
        this.records.put(item.getId(), newRecord);
        displayBorrowRecords();
    }

    public void deleteBorrowRecord(int itemId){
        this.records.remove(itemId);
        displayBorrowRecords();
    }
    private double calculateFine(Item item, long daysLate) {
        double finePerDay;
        switch (item.getTitle()) {
            case "Book":
                finePerDay = 3.0;
                break;
            case "Journal":
                finePerDay = 3.0;
                break;
            case "Video":
                finePerDay = 1.0;
                break;
            case "TechnicalPaper":
                finePerDay = 2.0;
                break;
            default:
                finePerDay = 0.0;
                break;
        }
        return finePerDay * daysLate;
    }
    private void displayBorrowRecords() {
        System.out.println("Lend Records:");
        System.out.println("--------------------------------------------------------");
        System.out.println("Borrower      | ID       | Item    | Library ID | Due Date | Fine");
        System.out.println("--------------------------------------------------------");
        records.forEach((key, value) -> {
            Borrower b = value.getBorrower();
            Item i = value.getItem();
            long daysLate = value.getBorrowDate().compareTo(value.getDueDate());
            double fine = calculateFine(i, daysLate);
            System.out.printf("%-14s | %-10s | %-8s | %-11s | %-9s| $%.2f%n",
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
