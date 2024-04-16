package Library;

// Item 1: Book
class Book implements Item {
    private int libraryId;
    private final String itemType = "Book";
    private String title;
    private String description;
    private final double finePerDay = 3.0;

    public Book(int libraryId, String title, String description) {
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
