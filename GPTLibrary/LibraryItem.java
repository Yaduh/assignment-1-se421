package GPTLibrary;
// Immutable class for library items
final class LibraryItem {
    private final int libraryId;
    private final String title;
    private final String description;

    public LibraryItem(int libraryId, String title, String description) {
        this.libraryId = libraryId;
        this.title = title;
        this.description = description;
    }

    public int getLibraryId() {
        return libraryId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}


