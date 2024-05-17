import java.time.LocalDate;

public interface BorrowRecordFactory {
    BorrowRecord create(Borrower borrower, Item item, LocalDate borrowDate);
}

