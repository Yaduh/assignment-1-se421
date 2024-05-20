package com.librarysystem.builders;

import com.librarysystem.entities.Item;


public class ItemBuilder{
    protected int libraryId;
    protected String itemType;
    protected String title;
    protected String description;
    protected double finePerDay;
    protected ItemCreator creator;
    public ItemBuilder(){
        this.libraryId = 0;
        this.itemType = null;
        this.title = null;
        this.description = null;
        this.finePerDay = 0;
    }

    public ItemBuilder(Item item){
        this.libraryId = item.getId();
        this.itemType = item.getItemType();
        this.title = item.getTitle();
        this.description = item.getDescription();
        this.finePerDay = item.getFinePerDay();
    }

    public ItemBuilder setCreator(ItemCreator creator){
        this.creator = creator;
        return this;
    }

    public ItemBuilder setId(int libraryId) {
        this.libraryId = libraryId;
        return this;
    }
    public ItemBuilder setTitle(String title) {
        this.title = title;
        return this;
    }
    public ItemBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public Item build(){
        return creator.createItem(libraryId, title, description);
    }
}
