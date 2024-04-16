package Library;

// Item 1: Book
class Book implements Items {
    private int libraryId;
    private String title;
    private String description;
    private int returnDeadline = 14; // 2 weeks
    private double finePerDay = 3.0;

    public Book(int libraryId, String title, String description) {
        this.libraryId = libraryId;
        this.title = title;
        this.description = description;
    }

    @Override
    public int getLibraryId() {
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
    public int getReturnDeadline() {
        return returnDeadline;
    }

    @Override
    public double getFinePerDay() {
        return finePerDay;
    }
}
