package Library;

public class Student implements Borrower{
    private int id;
    private final String borrowerType = "Student";

    public Student(int id){
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