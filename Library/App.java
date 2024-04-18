package Library;
public class App {
    public static void main(String[] args) {
        // for testing purposes
        Borrower f1 = new Faculty(1000);
        Borrower s1 = new Student(2000);

        // books
        Item b1 = new Book(100, "It's Kind of a Funny Story", "Ambitious New York City teenager Craig Gilner is determined to succeed at life - which means getting into the right high school to get into the right job. But once Craig aces his way into Manhattan's Executive Pre-Professional High School, the pressure becomes unbearable. He stops eating and sleeping until, one night, he nearly kills himself."),
        b2 = new Book(101, "Dance Dance Dance", "High-class call girls billed to Mastercard. A psychic 13-year-old dropout with a passion for Talking Heads. A hunky matinee idol doomed to play dentists and teachers. A one-armed beach-combing poet, an uptight hotel clerk and one very bemused narrator caught in the web of advanced capitalist mayhem. Combine this offbeat cast of characters with Murakami's idiosyncratic prose and out comes Dance Dance Dance."),
        b3 = new Book(102, "The Language of Flowers", "The Victorian language of flowers was used to convey romantic expressions: honeysuckle for devotion, asters for patience, and red roses for love. But for Victoria Jones, it’s been more useful in communicating mistrust and solitude. After a childhood spent in the foster-care system, she is unable to get close to anybody, and her only connection to the world is through flowers and their meanings. Now eighteen and emancipated from the system with nowhere to go, Victoria realizes she has a gift for helping others through the flowers she chooses for them. But an unexpected encounter with a mysterious stranger has her questioning what’s been missing in her life. And when she’s forced to confront a painful secret from her past, she must decide whether it’s worth risking everything for a second chance at happiness.");
        
        // videos
        Item v1 = new Video(200, "Happy Wheels - MOST EPIC VICTORY EVER", "Watch Toby die, ragequit, and fail more in Happy Wheels than anyone you've ever seen in any other game.\nThis TobyGames series is a lot of fun, I hope the amount you enjoy watching him rage his face off correlates with the amount of frustration he endured throughout this playthrough!\nToby also gives unique voices to Irresponsible Dad and Son, the Pogo Guy, and the old Wheelchair Man."),
        v2 = new Video(201, "How to be Ninja", "This is a dvd that shows you how to be an excellent ninja."),
        v3 = new Video(202, "Kanye West once said (PART 1)", "the contents of this video include iconic quotes from Ye West.");

        // journals
        Item j1 = new Journal(300, "Art History", "Art History, the journal of the Association for Art History, is an international, refereed journal that promotes world-class art-historical scholarship from across the globe."),
        j2 = new Journal(301, "Genomics, Proteomics and Bioinformatics", "Genomics, Proteomics and Bioinformatics (GPB) is interested in submissions across all areas of life science, biology, and biomedicine, focusing on large data acquisition, analysis, and curation."),
        j3 = new Journal(302, "British Journal of Radiology", "BJR is an international, multi-disciplinary journal covering the clinical and technical aspects of medical imaging, radiotherapy, oncology, medical physics, radiobiology and the underpinning sciences.");

        // technical papers
        Item tp1 = new TechnicalPaper(400, "Technical Paper 1", "test technical paper"),
        tp2 = new TechnicalPaper(401, "Technical Paper 1", "test technical paper"),
        tp3 = new TechnicalPaper(402, "Technical Paper 1", "test technical paper");

        LibrarySystem librarySystem = new LibrarySystem();
        librarySystem.addRecord(f1, b1);
        librarySystem.addRecord(s1, v1);

        librarySystem.deleteBorrowRecord(200);
        System.out.println(b1.getTitle() + b1.getDescription());

    }
    
}
