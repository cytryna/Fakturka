package sandobox.stackoverflow;

import java.util.List;

/**
 * Created by rwichrowski on 23.09.16.
 */
interface PersonService {

    List<Person> searchPersons(String searchString);
}
