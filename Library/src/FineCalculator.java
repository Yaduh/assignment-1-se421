package Library.src;

class FineCalculator {
        public double calculateFine(Item item, long daysLate) {
            if (daysLate <= 0) {
                return 0;
            }
            double finePerDay = item.getFinePerDay();
            return finePerDay * daysLate;
        }
    }
