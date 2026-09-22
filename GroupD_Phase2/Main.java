package GroupD_Phase2;

public class Main {
    public static void main(String[] args) {
        // Group D - CityCare Pharmacy Items mapped to Phase 2 subclasses
        Item[] items = {
            new PercentDiscountItem("Paracetamol (pack)", 1500.0, 6, 5),
            new NoDiscountItem("Cough Syrup", 6000.0),
            new FlatDiscountItem("Bandages", 2500.0, 4, 1000),
            new PercentDiscountItem("Vitamins", 20000.0, 2, 10)
        };

        // Quantities for receipt generation
        int[] quantities = {5, 2, 3, 2};
        double grandTotal = 0.0;

        System.out.println("================ CITYCARE PHARMACY RECEIPT ================");

        for (int i = 0; i < items.length; i++) {
            double lineTotal = items[i].calculateTotal(quantities[i]);
            System.out.printf("%-22s x%d = UGX %.2f%n", 
                items[i].getName(), quantities[i], lineTotal);
            grandTotal += lineTotal;
        }

        System.out.println("----------------------------------------------------------");
        System.out.printf("TOTAL               = UGX %.2f%n", grandTotal);
    }
}
