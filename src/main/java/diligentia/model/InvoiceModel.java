package diligentia.model;

import diligentia.entity.Company;
import diligentia.entity.Item;

import java.util.List;

public class InvoiceModel {

    private List<Item> item;

    private Company company;

    public List<Item> getItem() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
