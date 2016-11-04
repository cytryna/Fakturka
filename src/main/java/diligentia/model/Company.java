package diligentia.model;

import java.io.Serializable;

public class Company implements Serializable {

   private String taxIdentificationNumber;

    private String name;

    private String postCode;

    private String city;

    private String street;

    public Company() {
    }

    public Company(String taxIdentificationNumber, String name, String postCode, String city, String street) {
        setTaxIdentificationNumber(taxIdentificationNumber);
        setName(name);
        setPostCode(postCode);
        setCity(city);
        setStreet(street);
    }
    public String getTaxIdentificationNumber() {
        return taxIdentificationNumber;
    }

    public void setTaxIdentificationNumber(String taxIdentificationNumber) {
        this.taxIdentificationNumber = taxIdentificationNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

}
