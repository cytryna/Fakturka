package diligentia.model;

public class Item {

    private String name;

    private double price;

    private Unit unit = Unit.SZTUK;

    private int amount;

    private int tax = 22;
    private Double netValue;
    private Double grossValue;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getTax() {
        return tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }

    public Double getNetValue() {
        return price * amount;
    }

    public Double getTaxValue() {
        return tax * getNetValue();
    }

    public Double getGrossValue() {
        return getNetValue() + getTaxValue();
    }
}
