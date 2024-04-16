package Library;

public class App {
    public static void main(String[] args) {
        LibraryManager record = new LibraryManager();
        Item i1 = new Book(0, null, null);
        Borrower b1 = new Faculty(10);
        record.borrowRecord.put(b1, i1);
        System.out.println(record.borrowRecord);
    }
}
