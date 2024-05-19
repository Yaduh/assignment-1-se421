public class BorrowerBuilder implements BorrowerBuilderInterface {
    protected int id;
    protected String borrowerType;
    protected int borrowed;
    protected int borrowLimit;
    protected Borrower borrower;
    

    public BorrowerBuilder(){
        this.id = 0;
        this.borrowerType = null;
        this.borrowed = 0;
        this.borrowLimit = 5;
    }
    public BorrowerBuilder(Borrower borrower){
        this.id = borrower.getId();
        this.borrowerType = borrower.getBorrowerType();
        this.borrowed = borrower.getBorrowed();
    }

    public BorrowerBuilderInterface setId(int id){
        this.id = id;
        return this;
    }

    public BorrowerBuilderInterface buildStudent(){
        this.borrower = new Student(id);
        return this;
    }
    public BorrowerBuilderInterface buildStaff(){
        this.borrower = new Staff(id);
        return this;
    }

    public BorrowerBuilderInterface buildFaculty(){
        this.borrower = new Faculty(id);
        return this;
    }

    public Borrower build(){
        return borrower;
    }

}
