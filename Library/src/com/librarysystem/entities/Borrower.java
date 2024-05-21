package com.librarysystem.entities;

public abstract class Borrower {
    private final int id;
    private final String borrowerType;
    private int borrowed;
    private final int borrowLimit = 5;
    public Borrower(int id, String borrowerType){
        this.id = id;
        this.borrowerType = borrowerType;
    }
    public int getBorrowLimit(){
        return borrowLimit;
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
