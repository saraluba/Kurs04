package StreamsAndLambdas;

import java.time.LocalDate;

public class UserNameDemo {
    public static void main(String[] args) {
        Address krakow = new Address("Krakow");
        Person jan = new Person("Jan","Kowalski", LocalDate.of(1999,1,1),Sex.MAN,2300,krakow);
        Person ola = new Person("Ola","Nowak", null, Sex.WOMAN,  12300, krakow);
        System.out.println(Person.generateUserName(jan));
        System.out.println(Person.generateUserName(ola));
    }
}
