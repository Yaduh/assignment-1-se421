package com.librarysystem.modules;
import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.google.inject.TypeLiteral;
import com.librarysystem.lists.*;
import com.librarysystem.entities.*;
import com.librarysystem.utilities.*;
import com.librarysystem.main.*;
import com.librarysystem.records.*;
public class LibraryModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(new TypeLiteral<EntityList<Item>>() {}).to(ItemList.class);
        bind(new TypeLiteral<EntityList<Borrower>>() {}).to(BorrowerList.class);
        bind(Calculator.class).to(FineCalculator.class);
        bind(LibrarySystemInterface.class).to(LibrarySystem.class).in(Singleton.class);
        bind(BorrowRecordFactory.class).to(BorrowRecordFactoryImpl.class);


    }
}