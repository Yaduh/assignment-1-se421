package Library;
public class App {
    public static void main(String[] args) {
        Faculty b1 = new Faculty(10);
        Student b2 = new Student(20);

        Book i1 = new Book(10, "Book 1", "test book");
        Item i2 = new Video(20, "Video 1", "test video");

        LibrarySystem librarySystem = new LibrarySystem();
        librarySystem.addRecord(b1, i1);
        librarySystem.addRecord(b2, i2);

        librarySystem.deleteBorrowRecord(10);

    }
    
}
