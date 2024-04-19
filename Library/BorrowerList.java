package Library;

import java.util.ArrayList;
import java.util.List;

public class BorrowerList {
        private List<Borrower> borrowerList;
    
        public BorrowerList() {
            borrowerList = new ArrayList<>();
        }
    
        public void addBorrower(Borrower borrower) {
            borrowerList.add(borrower);
        }
    
        public void removeBorrower(Borrower borrower){
            borrowerList.remove(borrower);
        }
        public List<Borrower> getborrowerList() {
            return borrowerList;
        }
    
        public Borrower getBorrowerById(int id) {
            for (Borrower borrower : borrowerList) {
                if (borrower.getId() == id) {
                    return borrower;
                }
            }
            System.out.println("the Borrower ID is invalid"); // If Borrower with given id is not found
            return null; 
        }
        public void displayborrowerList() {
            System.out.println("---------------------------------------------------");
            System.out.println("ID | Type              | Ammount of Items Borrowed");
            System.out.println("---------------------------------------------------");
            for (Borrower borrower : borrowerList) {
                System.out.printf("%-3d| %-9s| %-2s%n",
                    borrower.getId(),
                    borrower.getBorrowerType(),
                    borrower.getBorrowed());
            }
            System.out.println("---------------------------------------------------");
        }

        
    }

