import java.time.LocalDate;

public class BorrowRecordFactoryImpl implements BorrowRecordFactory {
    @Override
    public BorrowRecord create(Borrower borrower, Item item, LocalDate borrowDate) {
        return new BorrowRecord(borrower, item, borrowDate);
    }
}
