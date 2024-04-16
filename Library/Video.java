package Library;

class Video implements Item {
    private int Id;
    private final String itemType = "Video";
    private String title;
    private String description;
    private final double finePerDay = 1.0;

    public Video(int Id, String title, String description) {
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

