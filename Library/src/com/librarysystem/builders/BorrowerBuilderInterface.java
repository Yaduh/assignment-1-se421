package com.librarysystem.builders;

import com.librarysystem.entities.Borrower;

public interface BorrowerBuilderInterface {
    
    BorrowerBuilderInterface setId(int id);
    BorrowerBuilderInterface buildStudent();
    BorrowerBuilderInterface buildStaff();
    BorrowerBuilderInterface buildFaculty();
    Borrower build();

    }

