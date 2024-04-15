package GPTLibrary;
import java.time.LocalDate;

// Immutable class for lending records
final class LendRecord {
    private final LibraryItem item;
    private final int memberId;
    private final LocalDate startDate;
    private final LocalDate dueDate;

    public LendRecord(LibraryItem item, int memberId, LocalDate startDate) {
        this.item = item;
        this.memberId = memberId;
        this.startDate = startDate;
        this.dueDate = startDate.plusWeeks(2); // Due date after 2 weeks
    }

    public LibraryItem getItem() {
        return item;
    }

    public int getMemberId() {
        return memberId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }
}
