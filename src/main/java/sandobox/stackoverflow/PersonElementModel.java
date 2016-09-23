package sandobox.stackoverflow;

/**
 * Created by rwichrowski on 23.09.16.
 */
public class PersonElementModel {

    private Person person;

    public PersonElementModel(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    @Override
    public String toString() {
        return person.getFirstName() + ", " + person.getLastName();
    }
}