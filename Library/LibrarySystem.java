package Library;
import java.util.HashMap;

public class LibrarySystem {
    private HashMap<Integer,BorrowRecord> records = new HashMap<>();

    public BorrowRecord getRecord(int ItemID){
        return this.records.get(ItemID);
    }

    public void addRecord(Borrower borrower,Item item){
        BorrowRecord newRecord = new BorrowRecord(borrower,item);
        this.records.put(item.getId(), newRecord);
        displayBorrowRecords();
    }
    
    public void deleteBorrowRecord(int itemID){
        this.records.remove(itemID);
        displayBorrowRecords();
    }

    private void displayBorrowRecords(){
        System.out.println();
        records.forEach((key, value) -> {
            Borrower b = value.getBorrower();
            Item i = value.getItem();
            
            System.out.println(b.getBorrowerType() 
            + " " + b.getId()  
            + " borrowed " + i.getType() 
            + " " + i.getId() 
            + " at " + value.getBorrowDate());
            
        });
        System.out.println("____________");

    }
}
