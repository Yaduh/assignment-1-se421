package com.librarysystem.lists;
import java.util.ArrayList;
import java.util.List;

import com.librarysystem.entities.Borrower;

public class BorrowerList implements ListInterface<Borrower>{
    private List<Borrower> borrowerList;
    
    public BorrowerList() {
        borrowerList = new ArrayList<>();
    }
    @Override
    public void addEntity(Borrower borrower) {
        borrowerList.add(borrower);
    }
    @Override
    public void removeEntity(Borrower borrower){
        borrowerList.remove(borrower);
    }
    @Override
    public Borrower getEntityById(int id) {
        for (Borrower borrower : borrowerList) {
            if (borrower.getId() == id) {
                return borrower;
            }
        }
        System.out.println("the Borrower ID is invalid"); // If Borrower with given id is not found
        return null; 
    }
    @Override
    public List<Borrower> getEntityList() {
        return borrowerList;
    }

        
    }

