package StreamsAndLambdas;

import java.util.Comparator;

public class ByBirthDayComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return o1.getBirthDay().compareTo(o2.getBirthDay());
    }
}
