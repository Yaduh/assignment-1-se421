package com.librarysystem.entities;


public final class Book extends Item {

    public Book(int libraryId, String title, String description) {
        super(libraryId, title, description, "Book", 3.0);
    }
   
}
