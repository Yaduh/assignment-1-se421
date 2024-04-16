package Library;

import java.util.HashMap;
import java.util.Date;
public class LibraryManager {
    private Item item;
    private Borrower borrower;
    private Date startDate;
    private Date dueDate;

    public HashMap<Borrower, Item> borrowRecord = new HashMap();
    
    // private final List<LendRecord> lendRecords = new ArrayList<>();

    // public void lendItem(LibraryItem item, int memberId, LocalDate startDate) {
    //     if (lendRecords.size() >= 5) {
    //         System.out.println("Cannot lend more than 5 items.");
    //         return;
    //     }

    //     lendRecords.add(new LendRecord(item, memberId, startDate));
    //     System.out.println("Item lent successfully.");
    //     printLendRecords();
    // }
    // public void returnItem(LibraryItem item, int memberId, LocalDate returnDate) {
    //     LendRecord recordToRemove = null;
    //     for (LendRecord record : lendRecords) {
    //         if (record.getItem().getLibraryId() == item.getLibraryId() && record.getMemberId() == memberId) {
    //             recordToRemove = record;
    //             break;
    //         }
    //     }
    
    //     if (recordToRemove != null) {
    //         lendRecords.remove(recordToRemove);
    //         System.out.println("Item returned successfully.");
    //         printLendRecords();
    //     } else {
    //         System.out.println("No matching lend record found.");
    //     }
    // }
    
    // private void printLendRecords() {
    //     System.out.println("Lend Records:");
    //     System.out.println("--------------------------------------------------------");
    //     System.out.println("Library ID | Title            | Due Date    | Fine");
    //     System.out.println("--------------------------------------------------------");
    //     for (LendRecord record : lendRecords) {
    //         LocalDate currentDate = LocalDate.now();
    //         long daysLate = Math.max(0, currentDate.compareTo(record.getDueDate()));
    //         double fine = calculateFine(record.getItem(), daysLate);
    //         System.out.printf("%-10s | %-16s | %-12s | $%.2f%n",
    //                 record.getItem().getLibraryId(),
    //                 record.getItem().getTitle(),
    //                 record.getDueDate(),
    //                 fine);
    //     }
    //     System.out.println("--------------------------------------------------------");
    // }
    
    // private double calculateFine(LibraryItem item, long daysLate) {
    //     double finePerDay;
    //     switch (item.getClass().getSimpleName()) {
    //         case "Book":
    //             finePerDay = 3.0;
    //             break;
    //         case "Journal":
    //             finePerDay = 3.0;
    //             break;
    //         case "Video":
    //             finePerDay = 1.0;
    //             break;
    //         case "TechnicalPaper":
    //             finePerDay = 2.0;
    //             break;
    //         default:
    //             finePerDay = 0.0;
    //             break;
    //     }
    //     return finePerDay * daysLate;
    // }
}
