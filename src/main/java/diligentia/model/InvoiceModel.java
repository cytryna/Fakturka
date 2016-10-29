package diligentia.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import diligentia.view.ViewObserver;

public class InvoiceModel {

    private List<ViewObserver> observers;
    private String number;
    private Company customer = new Company();
    private final Company salesman;
    private List<Item> item = new ArrayList<>();
    private LocalDate date = LocalDate.now();
    private String city = "Warszawa"; //TODO-rwichrowski Poprawić

    public InvoiceModel() {
        salesman = new Company("775-000-78-54", "Wich-Mot Edward Wichrowski", "09-500", "Gostynin", "Chopina 4");
    }

    public void addObservers(ViewObserver viewObserver) {
        observers.add(viewObserver);
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

    public List<Item> getItem() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
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
}

