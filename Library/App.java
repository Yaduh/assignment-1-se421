package Library;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        ItemList itemList = new ItemList();
        // for testing purposes
        Borrower stu1 = new Student(1000);
        Borrower f1 = new Faculty(2000);
        Borrower sta1 = new Staff(3000);

        // books
        itemList.addItem(new Book(100, "It's Kind of a Funny Story", "Ambitious New York City teenager Craig Gilner is determined to succeed at life..."));
        itemList.addItem(new Book(101, "Dance Dance Dance", "High-class call girls billed to Mastercard..."));
        itemList.addItem(new Book(102, "The Language of Flowers", "The Victorian language of flowers was used to convey romantic expressions..."));
        
        // videos
        itemList.addItem(new Video(200, "Happy Wheels - MOST EPIC VICTORY EVER", "This TobyGames series is a lot of fun..."));
        itemList.addItem(new Video(201, "How to be Ninja", "This is a dvd that shows you how to be an excellent ninja."));
        itemList.addItem(new Video(202, "Kanye West once said (PART 1)", "The contents of this video include iconic quotes from Ye West."));

        // journals
        itemList.addItem(new Journal(300, "Art History", "An international, refereed journal that promotes world-class art-historical scholarship from across the globe."));
        itemList.addItem(new Journal(301, "Genomics, Proteomics and Bioinformatics", "Interested in submissions across all areas of life science, biology, and biomedicine..."));
        itemList.addItem(new Journal(302, "British Journal of Radiology", "Covering the clinical and technical aspects of medical imaging, radiotherapy..."));

        // technical papers
        itemList.addItem(new TechnicalPaper(400, "Electromagnetic Compatibility Assessment of Electric Vehicles During DC-Charging with European Combined Charging System 2024-01-3008", "The ongoing energy transition will have a profound impact on future mobility..."));
        itemList.addItem(new TechnicalPaper(401, "Graph based cooperation strategies for automated vehicles in mixed traffic 2024-01-2982", "In the context of urban smart mobility, vehicles have to communicate with each other..."));
        itemList.addItem(new TechnicalPaper(402, "Optimal and Prototype Dimensioning of Electrified Drives for Automated Driving 2024-01-3021", "Electrified drives will change significantly in the wake of the further introduction of automated driving functions..."));

        LibrarySystem librarySystem = new LibrarySystem();
        //test
        System.out.println("==========================\n\tStart of test");
        itemList.displayItemList();
        librarySystem.addRecord(f1, itemList.getItemById(100), LocalDate.now()); 
        librarySystem.addRecord(f1, itemList.getItemById(101), LocalDate.now());
        librarySystem.addRecord(f1, itemList.getItemById(102), LocalDate.now().minusWeeks(12)); // overdue
        librarySystem.addRecord(f1, itemList.getItemById(201), LocalDate.now());
        librarySystem.addRecord(f1, itemList.getItemById(202), LocalDate.now().minusWeeks(4)); // overdue
        librarySystem.addRecord(f1, itemList.getItemById(301), LocalDate.now()); // 6th input - deny borrow  
        librarySystem.addRecord(stu1, itemList.getItemById(200), LocalDate.now().minusWeeks(8)); //overdue

        librarySystem.returnRecord(stu1, itemList.getItemById(200), LocalDate.now()); // fine- red
        librarySystem.returnRecord(f1, itemList.getItemById(100), LocalDate.now()); // no fine - default color
        librarySystem.returnRecord(f1, itemList.getItemById(202), LocalDate.now()); // fine - red
        librarySystem.returnRecord(f1, itemList.getItemById(102), LocalDate.now()); // fine - red
        System.out.println("\tEnd of test\n==========================");

        System.out.println("Welcome to the Library app");
        
    }
    
}
