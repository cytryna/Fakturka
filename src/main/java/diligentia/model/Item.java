package diligentia.model;

public class Item {

    private String name;
    private Double price = Double.valueOf(0);
    private int amount;
    private int tax = 22;
//   Double  getTaxValue
//    private Double netValue;
//    private Double grossValue;

//    private Unit unit = Unit.SZTUK;

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

//    public Unit getUnit() {
//        return unit;
//    }
//
//    public void setUnit(Unit unit) {
//        this.unit = unit;
//    }

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
        return ((double) tax / 100) * getNetValue();
    }

    public Double getGrossValue() {
        return getNetValue() + getTaxValue();
    }
}
