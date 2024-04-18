package Library;
abstract class Borrower {
    protected int id;
    protected String borrowerType;
    public Borrower(int id, String borrowerType){
        this.id = id;
        this.borrowerType = borrowerType;
    }
    public int getId(){
        return id;
    }

    public String getBorrowerType() {
        return borrowerType;
    }
}
