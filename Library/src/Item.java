

public abstract class Item {
    private final int libraryId;
    private final String itemType;
    private final String title;
    private final String description;
    private final double finePerDay;

    protected Item(int libraryId, String title, String description, String itemType, double finePerDay) {
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

    public String getItemType() {
        return itemType;
    }
    
} 
