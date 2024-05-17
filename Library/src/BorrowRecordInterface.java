import java.time.LocalDate;

public interface BorrowRecordInterface {
    LocalDate getBorrowDate();
    LocalDate getDueDate();
    Borrower getBorrower();
    Item getItem();
    double getFine();
    void setFine(double fine);
    BorrowRecord getRecordById(int recordId);
}
