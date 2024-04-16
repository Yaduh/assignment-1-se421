package Library;

public class BorrowRecord {
    private Borrower borrower;
    private Item item;

    public void setBorrower(Borrower borrower) {
        this.borrower = borrower;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Borrower getBorrower() {
        return this.borrower;
    }

    public Item getItem() {
        return this.item;
    }
}
