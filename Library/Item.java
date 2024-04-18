package Library;

abstract class Item {
    protected int libraryId;
    protected String itemType;
    protected String title;
    protected String description;
    protected double finePerDay;

    public Item(int libraryId, String title, String description, String itemType, double finePerDay) {
        this.libraryId = libraryId;
        this.title = title;
        this.description = description;
        this.itemType = itemType;
        this.finePerDay = finePerDay; 
    }

  
    public int getId() {
        return libraryId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public double getFinePerDay() {
        return finePerDay;
    }

    public String getType() {
        return itemType;
    }
    
} 