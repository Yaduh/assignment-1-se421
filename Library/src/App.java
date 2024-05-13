//Hema Shaswar Hs21123
//Yad Hawar Yh21145
package Library.src;
import java.time.LocalDate;
import java.util.Scanner;

public class App {
    public static void main(String... args) {
        ItemList itemList = new ItemList();
        BorrowerList borrowerList = new BorrowerList();
        // for testing purposes

        // Students
        borrowerList.addBorrower(new Student(1000));
        borrowerList.addBorrower(new Student(1001));
        borrowerList.addBorrower(new Student(1002));

        // Faculty
        borrowerList.addBorrower(new Faculty(2000));
        borrowerList.addBorrower(new Faculty(2001));
        borrowerList.addBorrower(new Faculty(2002));
        // Staff
        borrowerList.addBorrower(new Staff(3000));
        borrowerList.addBorrower(new Staff(3001));
        borrowerList.addBorrower(new Staff(3002));
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
        librarySystem.addRecord(borrowerList.getBorrowerById(1000), itemList.getItemById(100), LocalDate.now()); 
        librarySystem.addRecord(borrowerList.getBorrowerById(1000), itemList.getItemById(101), LocalDate.now());
        librarySystem.addRecord(borrowerList.getBorrowerById(1000), itemList.getItemById(102), LocalDate.now().minusWeeks(12)); // overdue
        librarySystem.addRecord(borrowerList.getBorrowerById(1000), itemList.getItemById(201), LocalDate.now());
        librarySystem.addRecord(borrowerList.getBorrowerById(1000), itemList.getItemById(202), LocalDate.now().minusWeeks(4)); // overdue
        librarySystem.addRecord(borrowerList.getBorrowerById(1000), itemList.getItemById(301), LocalDate.now()); // 6th input - deny borrow  
        librarySystem.addRecord(borrowerList.getBorrowerById(2000), itemList.getItemById(200), LocalDate.now().minusWeeks(8)); //overdue

        librarySystem.returnRecord(borrowerList.getBorrowerById(2000), itemList.getItemById(200), LocalDate.now()); // fine- red
        librarySystem.returnRecord(borrowerList.getBorrowerById(1000), itemList.getItemById(100), LocalDate.now()); // no fine - default color
        librarySystem.returnRecord(borrowerList.getBorrowerById(1000), itemList.getItemById(202), LocalDate.now()); // fine - red
        librarySystem.returnRecord(borrowerList.getBorrowerById(1000), itemList.getItemById(102), LocalDate.now()); // fine - red
        librarySystem.returnRecord(borrowerList.getBorrowerById(1000), itemList.getItemById(201), LocalDate.now());
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
                    itemList.displayItemList();
                    break;
                case 2:
                    borrowerList.displayborrowerList();
                    break;
                case 3:
                    librarySystem.displayBorrowRecords();
                    break;
                case 4:
                System.out.print("Please enter the Borrower's ID: ");
                int borrowerId = input.nextInt();
                System.out.print("please enter the Item's Library ID: ");
                int libraryId = input.nextInt();
                   librarySystem.addRecord(borrowerList.getBorrowerById(borrowerId), itemList.getItemById(libraryId), LocalDate.now());
                    break;
                case 5:
                System.out.print("Please enter the Borrower's ID: ");
                borrowerId = input.nextInt();
                System.out.print("please enter the Item's Library ID: ");
                libraryId = input.nextInt();
                   librarySystem.returnRecord(borrowerList.getBorrowerById(borrowerId), itemList.getItemById(libraryId), LocalDate.now());
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }
        }
    }
    
}
