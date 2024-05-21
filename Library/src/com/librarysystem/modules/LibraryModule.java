package com.librarysystem.modules;
import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.google.inject.TypeLiteral;
import com.librarysystem.lists.EntityList;
import com.librarysystem.lists.ItemList;
import com.librarysystem.lists.BorrowerList;
import com.librarysystem.entities.Item;
import com.librarysystem.entities.Borrower;
import com.librarysystem.utilities.Calculator;
import com.librarysystem.utilities.FineCalculator;
import com.librarysystem.main.LibrarySystem;
import com.librarysystem.main.LibraryService;
import com.librarysystem.records.BorrowRecordFactory;
import com.librarysystem.records.BorrowRecordFactoryImpl;

public class LibraryModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(new TypeLiteral<EntityList<Item>>() {}).to(ItemList.class);
        bind(new TypeLiteral<EntityList<Borrower>>() {}).to(BorrowerList.class);
        bind(Calculator.class).to(FineCalculator.class);
        bind(LibraryService.class).to(LibrarySystem.class).in(Singleton.class);
        bind(BorrowRecordFactory.class).to(BorrowRecordFactoryImpl.class);
        

    }
}