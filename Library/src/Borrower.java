package Library.src;
abstract class Borrower {
    protected int id;
    protected String borrowerType;
    protected int borrowed = 0;
    protected int borrowLimit;
    public Borrower(int id, String borrowerType){
        this.id = id;
        this.borrowerType = borrowerType;
        this.borrowLimit = 5;
    }
    public int getBorrowLimit(){
        return borrowLimit;
    }
    public void incrementBorrowed() {
        borrowed++;
    }
    public void decrementBorrowed() {
        borrowed--;
    }
    public int getBorrowed(){
        return borrowed;
    }
    public int getId(){
        return id;
    }

    public String getBorrowerType() {
        return borrowerType;
    }
}
