package diligentia.model;

import diligentia.view.ViewInterface;

import java.awt.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class InvoiceModel {

    private List<ViewInterface> observers;
    private String number;
    private Company customer = new Company();
    private final Company salesman;
    private List<Item> item;
    private LocalDate date = LocalDate.now();
    private String city = "Warszawa"; //TODO-rwichrowski Poprawić

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

