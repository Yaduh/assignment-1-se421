package com.librarysystem.builders;

import com.librarysystem.entities.Borrower;

public class BorrowerBuilder{
    protected int id;
    protected String borrowerType;
    protected int borrowed;
    protected final int borrowLimit;
    protected BorrowerCreator creator;

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
        this.borrowLimit = 5;
    }

    public BorrowerBuilder(BorrowerCreator creator){
        this.creator = creator;
        this.borrowLimit = 5;
    }
    public BorrowerBuilder incrementBorrowed() {
        if (this.borrowed < this.borrowLimit) {
            this.borrowed++;
        } else {
            System.out.println("Borrow limit reached");
        }
        return this;
    }

    public BorrowerBuilder decrementBorrowed() {
        if (this.borrowed > 0) {
            this.borrowed--;
        } else {
            System.out.println("No borrowed items to return");
        }
        return this;
    }

    public BorrowerBuilder setCreator(BorrowerCreator creator){
        this.creator = creator;
        return this;
    }

    public BorrowerBuilder setId(int id){
        this.id = id;
        return this;
    }

    public Borrower build(){
        return creator.createBorrower(id);
    }

}
