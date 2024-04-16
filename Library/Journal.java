package Library;

class Journal implements Item {
    private int libraryId;
    private final String itemType = "Journal";
    private String title;
    private String description;
    private final double finePerDay = 3.0;

    public Journal(int libraryId, String title, String description) {
        this.libraryId = libraryId;
        this.title = title;
        this.description = description;
    }

    @Override
    public int getId() {
        return libraryId;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double getFinePerDay() {
        return finePerDay;
    }

    @Override
    public String getType() {
        return itemType;
    }
}
