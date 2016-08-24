package diligentia.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Company { //TODO-rwichrowski może zrobić to zbstrakcyjną i dodac customer i sellsman
    @Id
    @GeneratedValue
    private int id;

    private String taxIdentificationNumber;

    private String name;

    private String address;

}
