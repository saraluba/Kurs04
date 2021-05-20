package StreamsAndLambdas;

import java.util.Comparator;

public class ByLastNameComparator implements Comparator<Person> { //the same with first name

    @Override
    public int compare(Person o1, Person o2) {
        return o1.getLastName().compareTo(o2.getLastName());
    }

}
