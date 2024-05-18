//Hema Shaswar hs21123
//Yad Hawar yh21145


import java.time.LocalDate;
import java.util.Scanner;

import com.google.inject.*;

public class App {
    public static void main(String... args) {
        Injector injector = Guice.createInjector(new LibraryModule());
        ListInterface<Item> itemList = injector.getInstance(new Key<ListInterface<Item>>(){});
        ListInterface<Borrower> borrowerList = injector.getInstance(new Key<ListInterface<Borrower>>(){});

        LibrarySystemInterface librarySystem = injector.getInstance(LibrarySystemInterface.class);

        BorrowRecordsDisplay display = new BorrowRecordsDisplay(librarySystem);
        librarySystem.registerListener(display);
        ItemBuilder itemBuilder = new ItemBuilder();
        
        

        // for testing purposes

        // Students
        borrowerList.addEntity(new Student(1000));
        borrowerList.addEntity(new Student(1001));
        borrowerList.addEntity(new Student(1002));

        // Faculty
        borrowerList.addEntity(new Faculty(2000));
        borrowerList.addEntity(new Faculty(2001));
        borrowerList.addEntity(new Faculty(2002));
        // Staff
        borrowerList.addEntity(new Staff(3000));
        borrowerList.addEntity(new Staff(3001));
        borrowerList.addEntity(new Staff(3002));
        // books
        itemList.addEntity(new Book(100, "It's Kind of a Funny Story", "Ambitious New York City teenager Craig Gilner is determined to succeed at life..."));
        itemList.addEntity(new Book(101, "Dance Dance Dance", "High-class call girls billed to Mastercard..."));
        itemList.addEntity(new Book(102, "The Language of Flowers", "The Victorian language of flowers was used to convey romantic expressions..."));
        
        // videos
        itemList.addEntity(new Video(200, "Happy Wheels - MOST EPIC VICTORY EVER", "This TobyGames series is a lot of fun..."));
        itemList.addEntity(new Video(201, "How to be Ninja", "This is a dvd that shows you how to be an excellent ninja."));
        itemList.addEntity(new Video(202, "Kanye West once said (PART 1)", "The contents of this video include iconic quotes from Ye West."));

        // journals
        itemList.addEntity(new Journal(300, "Art History", "An international, refereed journal that promotes world-class art-historical scholarship from across the globe."));
        itemList.addEntity(new Journal(301, "Genomics, Proteomics and Bioinformatics", "Interested in submissions across all areas of life science, biology, and biomedicine..."));
        itemList.addEntity(new Journal(302, "British Journal of Radiology", "Covering the clinical and technical aspects of medical imaging, radiotherapy..."));

        // technical papers
        itemList.addEntity(new TechnicalPaper(400, "Electromagnetic Compatibility Assessment of Electric Vehicles During DC-Charging with European Combined Charging System 2024-01-3008", "The ongoing energy transition will have a profound impact on future mobility..."));
        itemList.addEntity(new TechnicalPaper(401, "Graph based cooperation strategies for automated vehicles in mixed traffic 2024-01-2982", "In the context of urban smart mobility, vehicles have to communicate with each other..."));
        itemList.addEntity(new TechnicalPaper(402, "Optimal and Prototype Dimensioning of Electrified Drives for Automated Driving 2024-01-3021", "Electrified drives will change significantly in the wake of the further introduction of automated driving functions..."));

        //test
        System.out.println("==========================\n\tStart of test");
        librarySystem.displayItemList(itemList);
        librarySystem.addRecord(borrowerList.getEntityById(1000), itemList.getEntityById(100), LocalDate.now()); 
        librarySystem.addRecord(borrowerList.getEntityById(1000), itemList.getEntityById(101), LocalDate.now());
        librarySystem.addRecord(borrowerList.getEntityById(1000), itemList.getEntityById(102), LocalDate.now().minusWeeks(12)); // overdue
        librarySystem.addRecord(borrowerList.getEntityById(1000), itemList.getEntityById(201), LocalDate.now());
        librarySystem.addRecord(borrowerList.getEntityById(1000), itemList.getEntityById(202), LocalDate.now().minusWeeks(4)); // overdue
        librarySystem.addRecord(borrowerList.getEntityById(1000), itemList.getEntityById(301), LocalDate.now()); // 6th input - deny borrow  
        librarySystem.addRecord(borrowerList.getEntityById(2000), itemList.getEntityById(200), LocalDate.now().minusWeeks(8)); //overdue

        librarySystem.returnRecord(borrowerList.getEntityById(2000), itemList.getEntityById(200)); // fine- red
        librarySystem.returnRecord(borrowerList.getEntityById(1000), itemList.getEntityById(100)); // no fine - default color
        librarySystem.returnRecord(borrowerList.getEntityById(1000), itemList.getEntityById(202)); // fine - red
        librarySystem.returnRecord(borrowerList.getEntityById(1000), itemList.getEntityById(102)); // fine - red
        librarySystem.returnRecord(borrowerList.getEntityById(1000), itemList.getEntityById(201));
        System.out.println("\tEnd of test\n==========================");


        // Start of App
        Scanner input = new Scanner(System.in);
        int choice = -1;
        while (choice != 0) {
                    System.out.println("Menu:\nOperations:\n1. View items list\n2. View borrowers list(for testing purposes)\n3. Display records\n4. Add record\n5. Return record\n0. Exit");
                    System.out.print("Enter the number corresponding to the operation you want to perform: ");
                    choice = input.nextInt();
        System.out.println("Welcome to the Library app");
            switch (choice) {
                case 1:
                    librarySystem.displayItemList(itemList);
                    break;
                case 2:
                    librarySystem.displayborrowerList(borrowerList);
                    break;
                case 3:
                    librarySystem.displayBorrowRecords();
                    break;
                case 4:
                System.out.print("Please enter the Borrower's ID: ");
                int borrowerId = input.nextInt();
                System.out.print("please enter the Item's Library ID: ");
                int libraryId = input.nextInt();
                   librarySystem.addRecord(borrowerList.getEntityById(borrowerId), itemList.getEntityById(libraryId), LocalDate.now());
                    break;
                case 5:
                System.out.print("Please enter the Borrower's ID: ");
                borrowerId = input.nextInt();
                System.out.print("please enter the Item's Library ID: ");
                libraryId = input.nextInt();
                   librarySystem.returnRecord(borrowerList.getEntityById(borrowerId), itemList.getEntityById(libraryId));
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }
        }
        input.close();
    }
    
    
}