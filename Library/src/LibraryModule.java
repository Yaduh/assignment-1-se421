import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;

public class LibraryModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(new TypeLiteral<ListInterface<Item>>() {}).to(ItemList.class);
        bind(new TypeLiteral<ListInterface<Borrower>>() {}).to(BorrowerList.class);
        bind(FineCalculatorInterface.class).to(FineCalculator.class);
        bind(LibrarySystemInterface.class).to(LibrarySystem.class);
        bind(BorrowRecordFactory.class).to(BorrowRecordFactoryImpl.class);

        
    }
}