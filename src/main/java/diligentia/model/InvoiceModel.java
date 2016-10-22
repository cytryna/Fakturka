package diligentia.model;

import diligentia.view.ViewInterface;

import java.util.List;

public class InvoiceModel {

    private List<ViewInterface> observers;
    private String number;
    private Company company;
    private List<Item> item;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Item> getItem() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }
}
