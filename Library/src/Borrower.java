
abstract class Borrower {
    private final int id;
    private final String borrowerType;
    private int borrowed = 0;
    private final int borrowLimit = 5;
    public Borrower(int id, String borrowerType){
        this.id = id;
        this.borrowerType = borrowerType;
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
