package Library;

public class Staff implements Borrower{
    private int id;

    public void setId(int id){
        this.id = id;
    }
    
    @Override
    public int getId(){
        return this.id;
    }
}
