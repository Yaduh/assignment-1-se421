package Library;
import java.util.Date;

public class BorrowRecord {
    private Borrower borrower;
    private Item item;
    private Date BorrowDate;

    public BorrowRecord(Borrower borrower, Item item){
        setBorrowDate();
        setBorrower(borrower);
        setItem(item);
    }

    public void setBorrowDate() {
        this.BorrowDate = new Date();
    }

    public void setBorrower(Borrower borrower) {
        this.borrower = borrower;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Date getBorrowDate() {
        return this.BorrowDate;
    }

    public Borrower getBorrower() {
        return this.borrower;
    }

    public Item getItem() {
        return this.item;
    }
}
