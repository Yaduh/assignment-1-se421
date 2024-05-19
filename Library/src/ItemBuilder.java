public class ItemBuilder implements ItemBuilderInterface {
    protected int libraryId;
    protected String itemType;
    protected String title;
    protected String description;
    protected double finePerDay;
    private Item item;
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
    public ItemBuilderInterface setId(int libraryId) {
        this.libraryId = libraryId;
        return this;
    }
    @Override
    public ItemBuilderInterface setTitle(String title) {
        this.title = title;
        return this;
    }
    @Override
    public ItemBuilderInterface setDescription(String description) {
        this.description = description;
        return this;
    }
    @Override
    public ItemBuilderInterface buildBook(){
        this.item = new Book(libraryId, title, description);
        return this;
    }
    @Override
    public ItemBuilderInterface buildJournal(){
        this.item = new Journal(libraryId, title, description);
        return this;
    }
    @Override
    public ItemBuilderInterface buildTechnicalPaper(){
        this.item = new TechnicalPaper(libraryId, title, description);
        return this;
    }
    @Override
    public ItemBuilderInterface buildVideo(){
        this.item = new Video(libraryId, title, description);
        return this;
    }

    @Override
    public Item build(){
        return item;
    }
}
