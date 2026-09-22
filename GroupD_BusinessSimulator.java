/**
 * GroupD_BusinessSimulator
 *
 * A simple procedural billing simulator for "CityCare Pharmacy".
 * It stores item names, unit prices, and purchased quantities in
 * parallel arrays, then prints a price list and an itemized receipt
 * that applies a different discount rule per item.
 *
 * Usage: run main() directly — quantities are hard-coded for testing
 * rather than read from user input.
 */
public class GroupD_BusinessSimulator {

    /**
     * Program entry point. Builds the item/price/quantity data,
     * prints the pharmacy price list, then generates and prints
     * an itemized receipt with per-item discounts and a grand total.
     *
     * @param args command-line arguments (unused)
     */
    public static void main(String[] args) {
        // Parallel arrays for item names and prices
        String[] items = {
            "Paracetamol (pack)", 
            "Cough Syrup", 
            "Bandages", 
            "Vitamins"
        };
        double[] prices = {1500.0, 6000.0, 2500.0, 20000.0};

        // Quantities set directly for testing (5, 2, 3, 2)
        int[] quantities = {5, 2, 3, 2};

        // Display price list using loop method
        displayPriceList(items, prices);

        // Print itemized receipt and calculate grand total
        System.out.println("==== RECEIPT ====");
        double grandTotal = 0.0;

        for (int i = 0; i < items.length; i++) {
            // Calculate discounted subtotal using custom method
            double itemSubtotal = calculateSubtotal(i, prices[i], quantities[i]);
            
            // Get discount status note
            String discountNote = getDiscountNote(i, quantities[i]);

            // Accumulate grand total
            grandTotal += itemSubtotal;

            // Output receipt line item
            System.out.printf("%-20s x%d = UGX %.2f %s%n",
                items[i], quantities[i], itemSubtotal, discountNote);
        }

        System.out.println("--------------------------------------------------");
        System.out.printf("TOTAL               = UGX %.2f%n", grandTotal);
    }

    /**
     * Custom Method 1: Displays the pharmacy's numbered price list.
     * Iterates through the parallel name/price arrays using an index
     * so each item can be printed with a matching line number.
     *
     * @param names  array of item names, in display order
     * @param prices array of unit prices, aligned by index to {@code names}
     */
    public static void displayPriceList(String[] names, double[] prices) {
        System.out.println("==== CITYCARE PHARMACY ====");
        for (int i = 0; i < names.length; i++) {
            System.out.printf("%d. %-20s UGX %.2f%n", (i + 1), names[i], prices[i]);
        }
        System.out.println();
    }

    /**
     * Custom Method 2: Computes the subtotal for one line item after
     * applying that item's specific discount rule.
     *
     * Discount rules (by item index):
     * <ul>
     *   <li>0 — Paracetamol: 5% off when quantity is 6 or more</li>
     *   <li>1 — Cough Syrup: never discounted</li>
     *   <li>2 — Bandages: flat UGX 1,000 off when quantity is 4 or more</li>
     *   <li>3 — Vitamins: 10% off when quantity is 2 or more</li>
     * </ul>
     *
     * @param itemIndex index of the item in the items/prices arrays,
     *                  used to select which discount rule applies
     * @param price     unit price of the item
     * @param quantity  number of units purchased
     * @return the subtotal (price * quantity) after any applicable discount
     */
    public static double calculateSubtotal(int itemIndex, double price, int quantity) {
        double totalBeforeDiscount = price * quantity;

        // Rule 0: Paracetamol — 5% off if buying 6 or more
        if (itemIndex == 0) {
            if (quantity >= 6) {
                return totalBeforeDiscount * 0.95;
            }
        } 
        // Rule 1: Cough Syrup — Never discounted
        else if (itemIndex == 1) {
            return totalBeforeDiscount;
        } 
        // Rule 2: Bandages — UGX 1,000 off total if buying 4 or more
        else if (itemIndex == 2) {
            if (quantity >= 4) {
                return totalBeforeDiscount - 1000.0;
            }
        } 
        // Rule 3: Vitamins — 10% off if buying 2 or more
        else if (itemIndex == 3) {
            if (quantity >= 2) {
                return totalBeforeDiscount * 0.90;
            }
        }
        return totalBeforeDiscount;
    }

    /**
     * Custom Method 3: Returns a human-readable note describing whether
     * a discount was applied for the given item.
     *
     * @param itemIndex index of the item, used to select the matching rule
     * @param quantity  number of units purchased
     * @return a short receipt annotation
     */
    public static String getDiscountNote(int itemIndex, int quantity) {
        if (itemIndex == 0) {
            return (quantity >= 6) ? "(5% discount applied)" : "(no discount - fewer than 6)";
        } else if (itemIndex == 1) {
            return "(no discount)";
        } else if (itemIndex == 2) {
            return (quantity >= 4) ? "(UGX 1,000 discount applied)" : "(no discount - fewer than 4)";
        } else if (itemIndex == 3) {
            return (quantity >= 2) ? "(10% discount applied)" : "(no discount - fewer than 2)";
        }
        return "";
    }
}