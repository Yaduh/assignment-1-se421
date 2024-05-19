public interface BorrowerBuilderInterface {
    
    BorrowerBuilderInterface setId(int id);
    BorrowerBuilderInterface buildStudent();
    BorrowerBuilderInterface buildStaff();
    BorrowerBuilderInterface buildFaculty();
    Borrower build();

    }

