package com.librarysystem.builders;
import com.librarysystem.entities.Item;

public interface ItemBuilderInterface {
    ItemBuilderInterface setId(int libraryId);
    ItemBuilderInterface setTitle(String title);
    ItemBuilderInterface setDescription(String description);
    ItemBuilderInterface buildBook();
    ItemBuilderInterface buildJournal();
    ItemBuilderInterface buildTechnicalPaper();
    ItemBuilderInterface buildVideo();
    Item build();
    
}
