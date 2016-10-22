package diligentia.model;

import diligentia.view.ViewInterface;

import java.util.List;

public class InvoiceModel {

    private List<ViewInterface> observers;
    private String number;
    private Company customer = new Company();
    private final Company salesman;
    private List<Item> item;

    public InvoiceModel() {
        salesman = new Company("NIP 775-000-78-54", "Wich-Mot Edward Wichrowski", "09-500", "Gostynin", "ul. Chopina 4");
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Company getCustomer() {
        return customer;
    }

    public void setCustomer(Company customer) {
        this.customer = customer;
    }

    public Company getSalesman() {
        return salesman;
    }

    public List<Item> getItem() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }

}

