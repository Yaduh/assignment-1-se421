package Library;

public class Staff implements Borrower{
    private int id;
    private final String borrowerType = "Staff";
    public Staff(int id){
        setId(id);
    }
    public void setId(int id){
        this.id = id;
    }
    
    @Override
    public int getId(){
        return this.id;
    }

    @Override
    public String getBorrowerType() {
        return borrowerType;
    }
}
