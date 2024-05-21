package com.librarysystem.main;
//Hema Shaswar hs21123
//Yad Hawar yh21145


import java.time.LocalDate;
import java.util.Scanner;

import com.google.inject.*;
import com.librarysystem.lists.EntityList;
import com.librarysystem.entities.*;
import com.librarysystem.modules.LibraryModule;
import com.librarysystem.records.BorrowRecordsDisplay;
import com.librarysystem.builders.BorrowerBuilder;
import com.librarysystem.builders.ItemBuilder;


public class App {
    public static void main(String... args) {
        Injector injector = Guice.createInjector(new LibraryModule());
        
        EntityList<Item> itemList = injector.getInstance(new Key<EntityList<Item>>(){});
        EntityList<Borrower> borrowerList = injector.getInstance(new Key<EntityList<Borrower>>(){});

        LibraryService librarySystem = injector.getInstance(LibraryService.class);
        BorrowRecordsDisplay display = new BorrowRecordsDisplay(librarySystem);
        librarySystem.registerListener(display);
        ItemBuilder itemBuilder = new ItemBuilder();
        BorrowerBuilder borrowerBuilder = new BorrowerBuilder();
        
        

        // for testing purposes

        // Students
        borrowerList.addEntity(borrowerBuilder.setCreator(Student::new)
        .setId(1000)
        .build());
        borrowerList.addEntity(borrowerBuilder.setCreator(Student::new)
        .setId(1001)
        .build());
        borrowerList.addEntity(borrowerBuilder.setCreator(Student::new)
        .setId(1002)
        .build());

        // Faculty
        borrowerList.addEntity(borrowerBuilder.setCreator(Faculty::new)
        .setId(2000)
        .build());
        borrowerList.addEntity(borrowerBuilder.setCreator(Faculty::new)
        .setId(2001)
        .build());
        borrowerList.addEntity(borrowerBuilder.setCreator(Faculty::new)
        .setId(2002)
        .build());
        // Staff
        borrowerList.addEntity(borrowerBuilder.setCreator(Staff::new)
        .setId(3000)
        .build());
        borrowerList.addEntity(borrowerBuilder.setCreator(Staff::new)
        .setId(3001)
        .build());
        borrowerList.addEntity(borrowerBuilder.setCreator(Staff::new)
        .setId(3002)
        .build());
        
        // books
        itemList.addEntity(itemBuilder.setCreator(Book::new)
        .setId(100)
        .setTitle("It's Kind of a Funny Story")
        .setDescription("Ambitious New York City teenager Craig Gilner is determined to succeed at life...")
        .build());

        itemList.addEntity(itemBuilder.setCreator(Book::new)
        .setId(101)
        .setTitle("Dance Dance Dance")
        .setDescription("High-class call girls billed to Mastercard...")
        .build());

        itemList.addEntity(itemBuilder.setCreator(Book::new)
        .setId(102)
        .setTitle("The Language of Flowers")
        .setDescription("The Victorian language of flowers was used to convey romantic expressions...")
        .build());
        
        // videos
        itemList.addEntity(itemBuilder.setCreator(Video::new)
        .setId(200)
        .setTitle("Happy Wheels - MOST EPIC VICTORY EVER")
        .setDescription("This TobyGames series is a lot of fun...")
        .build());

        itemList.addEntity(itemBuilder.setCreator(Video::new)
        .setId(201)
        .setTitle("How to be Ninja")
        .setDescription("This is a dvd that shows you how to be an excellent ninja.")
        .build());

        itemList.addEntity(itemBuilder.setCreator(Video::new)
        .setId(202)
        .setTitle("Kanye West once said (PART 1)")
        .setDescription("The contents of this video include iconic quotes from Ye West.")
        .build());

        // journals
        itemList.addEntity(itemBuilder.setCreator(Journal::new)
        .setId(300)
        .setTitle("Art History")
        .setDescription("An international, refereed journal that promotes world-class art-historical scholarship from across the globe.")
        .build());

        itemList.addEntity(itemBuilder.setCreator(Journal::new)
        .setId(301)
        .setTitle("Genomics, Proteomics and Bioinformatics")
        .setDescription("Interested in submissions across all areas of life science, biology, and biomedicine...")
        .build());

        itemList.addEntity(itemBuilder.setCreator(Journal::new)
        .setId(302)
        .setTitle("British Journal of Radiology")
        .setDescription("Covering the clinical and technical aspects of medical imaging, radiotherapy...")
        .build());

        // technical papers

        itemList.addEntity(itemBuilder.setCreator(TechnicalPaper::new)
        .setId(400)
        .setTitle("Electromagnetic Compatibility Assessment of Electric Vehicles During DC-Charging with European Combined Charging System 2024-01-3008")
        .setDescription("The ongoing energy transition will have a profound impact on future mobility...")
        .build());

        itemList.addEntity(itemBuilder.setCreator(TechnicalPaper::new)
        .setId(401)
        .setTitle( "Graph based cooperation strategies for automated vehicles in mixed traffic 2024-01-2982")
        .setDescription("In the context of urban smart mobility, vehicles have to communicate with each other...")
        .build());

        itemList.addEntity(itemBuilder.setCreator(TechnicalPaper::new)
        .setId(402)
        .setTitle("Optimal and Prototype Dimensioning of Electrified Drives for Automated Driving 2024-01-3021")
        .setDescription("Electrified drives will change significantly in the wake of the further introduction of automated driving functions...")
        .build());

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