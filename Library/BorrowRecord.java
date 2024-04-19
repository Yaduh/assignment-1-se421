package Library;
import java.time.LocalDate;

class BorrowRecord {
    private Borrower borrower;
    private Item item;
    private LocalDate borrowDate;
    private LocalDate dueDate;
    public BorrowRecord(Borrower borrower, Item item){
        setBorrowDate();
        setBorrower(borrower);
        setItem(item);
    }

    public void setBorrowDate() {
        this.borrowDate = LocalDate.now();

    }
    public void setDueDate() {
        this.dueDate = borrowDate.plusDays(14);
    }

    public void setBorrower(Borrower borrower) {
        this.borrower = borrower;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public LocalDate getBorrowDate() {
        return this.borrowDate;
    }
    public LocalDate getDueDate(){
        return this.dueDate;
    }

    public Borrower getBorrower() {
        return this.borrower;
    }

    public Item getItem() {
        return this.item;
    }
}
