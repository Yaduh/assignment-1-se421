package Library;
import java.time.LocalDate;

class LendRecord {
    private Borrower borrower;
    private Item item;
    private double fine;
    private LocalDate borrowDate;
    private LocalDate dueDate;
    public LendRecord(Borrower borrower, Item item, LocalDate borrowDate){
        this.borrower = borrower;
        this.item = item;
        this.borrowDate = borrowDate;
        this.dueDate = borrowDate.plusWeeks(2);
    }

    public LocalDate getBorrowDate() {
       return borrowDate;
    }
    public LocalDate getDueDate(){
        return dueDate;
    }
    
    public Borrower getBorrower() {
        return this.borrower;
    }

    public Item getItem() {
        return this.item;
    }
    public double getFine(){
        return this.fine;
    }
    public void setFine(double fine) {
        this.fine = fine;
    }
}
