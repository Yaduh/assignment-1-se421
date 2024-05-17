
class FineCalculator implements FineCalculatorInterface {

        @Override
        public double calculateFine(BorrowRecord record) {
            if (record.isOverdue()) {
                double fineRate = record.getItem().getFinePerDay();
                record.updateFine(fineRate);
                return record.getFine();
                
            }
            return 0;
        }
    }
