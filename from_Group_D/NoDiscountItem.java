package GroupD_Phase2;

public class NoDiscountItem extends Item {
    public NoDiscountItem(String name, double price) {
        super(name, price);
    }
    // No override needed; Item's calculateTotal() is already correct
}
