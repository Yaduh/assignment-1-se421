package Library;

// Item 4: Technical Papers
class TechnicalPapers implements Item {
    private int libraryId;
    private String title;
    private String description;
    private double finePerDay = 2.0;

    public TechnicalPapers(int libraryId, String title, String description) {
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
    public double getFinePerDay() {
        return finePerDay;
    }
}
