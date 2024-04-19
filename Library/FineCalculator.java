package Library;

class FineCalculator {
    public double calculateFine(Item item, int daysLate) {
        double finePerDay;
        switch (item.getItemType()) {
            case "Book":
                finePerDay = 3.0;
                break;
            case "Journal":
                finePerDay = 3.0;
                break;
            case "Video":
                finePerDay = 1.0;
                break;
            case "TechnicalPaper":
                finePerDay = 2.0;
                break;
            default:
                finePerDay = 0.0;
                break;
        }
        return finePerDay * daysLate;
    }
}
