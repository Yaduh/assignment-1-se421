public class ItemBuilder implements Builder {
    protected int libraryId;
    protected String itemType;
    protected String title;
    protected String description;
    protected double finePerDay;
    
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
    @Override
    public ItemBuilder setId(int libraryId) {
        this.libraryId = libraryId;
        return this;
    }
    @Override
    public ItemBuilder setItemType(String itemType) {
        this.itemType = itemType;
        return this;
    }
    @Override
    public ItemBuilder setTitle(String title) {
        this.title = title;
        return this;
    }
    @Override
    public ItemBuilder setDescription(String description) {
        this.description = description;
        return this;
    }
    @Override
    public Item build(){
        return new Item(libraryId, itemType, title, description, finePerDay);
    }
}
