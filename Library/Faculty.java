package Library;

public class Faculty implements Borrower{
    private int id;

    public Faculty(int id){
        setId(id);
    }
    public void setId(int id){
        this.id = id;
    }

    @Override
    public int getId(){
        return this.id;
    }
}
