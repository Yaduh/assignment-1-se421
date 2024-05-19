package com.librarysystem.entities;


public final class Video extends Item {

    public Video(int libraryId, String title, String description) {
        super(libraryId, title, description, "Video", 1.0);
    }

}

