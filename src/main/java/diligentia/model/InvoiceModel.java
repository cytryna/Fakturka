package diligentia.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import diligentia.util.DigitsToLiteral;
import diligentia.view.ViewObserver;

public class InvoiceModel {

    private List<ViewObserver> observers = new ArrayList<>();
    private String number;
    private Company customer = new Company();
    private final Company salesman;
    private List<Item> items = new ArrayList<>();
    private LocalDate date = LocalDate.now();
    private String city = "Warszawa"; //TODO-rwichrowski Poprawić

    public InvoiceModel() {
        salesman = new Company("775-000-78-54", "Wich-Mot Edward Wichrowski", "09-500", "Gostynin", "Chopina 4");
    }

    public void addObservers(ViewObserver viewObserver) {
        observers.add(viewObserver);
    }

    public void firePropertyChange() {
        refreshView();
    }

    public void refreshView() {
        observers.stream().forEach(new Consumer<ViewObserver>() {
            @Override
            public void accept(ViewObserver viewObserver) {
                viewObserver.refreshView();
            }
        });
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

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Double getGlobalNetValue() {
        Double value = Double.valueOf(0);
        for (Item item : items) {
            value += item.getNetValue();
        }
        return value;
    }

    public Double getGlobalTaxValue() {
        Double value = Double.valueOf(0);
        for (Item item : items) {
            value += item.getTaxValue();
        }
        return value;
    }

    public Double getGlobalGrossValue() {
        Double value = Double.valueOf(0);
        for (Item item : items) {
            value += item.getGrossValue();
        }
        return value;
    }

    public String getGlobalGrossValueText() {
        return DigitsToLiteral.tranlate(getGlobalGrossValue());
    }
}

