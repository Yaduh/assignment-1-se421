package Library;

class TechnicalPaper implements Item {
    private int Id;
    private final String itemType = "Technical Papers";
    private String title;
    private String description;
    private final double finePerDay = 2.0;

    public TechnicalPaper(int Id, String title, String description) {
        this.Id = Id;
        this.title = title;
        this.description = description;
    }

    @Override
    public int getId() {
        return Id;
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
