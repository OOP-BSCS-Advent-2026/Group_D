package GroupD_Phase2;

public class PercentDiscountItem extends Item {
    private int threshold;
    private double percentOff;

    public PercentDiscountItem(String name, double price, int threshold, double percentOff) {
        super(name, price);
        this.threshold = threshold;
        this.percentOff = percentOff;
    }

    
}
