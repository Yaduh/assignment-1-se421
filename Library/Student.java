package Library;

public class Student implements Borrower{
    private int id;

    public void setId(int id){
        this.id = id;
    }
    
    @Override
    public int getId(){
        return this.id;
    }
}