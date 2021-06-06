package StreamsAndLambdas;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class PersonDemo {

    public static void main(String[] args) {
        Address krakow = new Address("Krakow");
        Address jawor = new Address("Jawor");
        List<Person> personList = List.of(new Person("Jan", "Kowalski", LocalDate.of(1944, 03, 14), Sex.MAN, 2300, krakow),
                new Person("Iga", "Nowak", LocalDate.of(1998, 12, 12), Sex.WOMAN, 4000, jawor),
                new Person("Piotr", "Malinowski", LocalDate.of(1984,6,1), Sex.MAN, 7900, krakow),
                new Person("Barbara", "Andrus", LocalDate.of(1974,7,7), Sex.WOMAN, 10000, jawor),
                new Person("Damian", "Dudkowski", LocalDate.of(1977, 9, 27), Sex.MAN, 1500, jawor),
                new Person("Filip","Buczkowski", LocalDate.of(1969,02,20), Sex.MAN, 8700, krakow),
                new Person("Nina","Kołaczkowska", LocalDate.of(2010,04,3), Sex.WOMAN, 8700, krakow));

        List<String> menUnder65 = personList.stream().sorted(new ByBirthDayComparator())
                .filter(person -> person.sex.equals(Sex.MAN))
                .filter(man -> man.getAge() < 65)
                .map(man -> man.toString())
                .collect(Collectors.toList());

        List<String> womenSalary = personList.stream().sorted(new ByLastNameComparator().reversed())
                .filter(person -> person.sex.equals(Sex.WOMAN))
                .filter(woman -> woman.getSalary() < 5000)
                .map(woman -> woman.toString())
                .collect(Collectors.toList());

        List<String> personFromKrakowUnder18 = personList.stream().sorted(new ByLastNameComparator())
                .filter(person -> person.getAge() < 18)
                .filter(person -> person.getAddress().equals(krakow))
                .map(person -> person.toString())
                .collect(Collectors.toList());

        List<String> notFromKrakow = personList.stream().sorted(new ByLastNameComparator().reversed())
                .filter(person -> !person.getAddress().equals(krakow))
                .map(person -> person.toString())
                .collect(Collectors.toList());

        long averageSalary = personList.stream()
                .mapToLong(Person::getSalary)
                .reduce(0, (sum, salary) -> sum + salary/personList.stream().count());



        long numberOfWomanKrakow = personList.stream()
                .filter(person -> person.sex.equals(Sex.WOMAN))
                .filter(woman -> woman.getAddress().equals(krakow))
                .count();

        long numberOfMenAfter65 = personList.stream()
                .filter(person -> person.sex.equals(Sex.MAN))
                .filter(man -> man.getAge() > 65)
                .count();

        Optional<String> oldestPerson = personList.stream()
                .min(new ByBirthDayComparator())
                .map(person -> person.toString());

        Optional<String> youngestPerson = personList.stream()
                .max(new ByBirthDayComparator())
                .map(person -> person.toString());

        long totalSalary = personList.stream()
                .map(person -> person.getSalary())
                .reduce(0, Integer::sum);

        Boolean letterAFirstNameCheck = personList.stream()
                .map(person -> person.getFirstName())
                .anyMatch(name -> name.startsWith("A"));

        Boolean letterALastNameCheck = personList.stream()
                .map(person -> person.getLastName())
                .allMatch(name -> name.contains("a"));


        System.out.println(menUnder65);
        System.out.println(womenSalary);
        System.out.println(personFromKrakowUnder18);
        System.out.println(notFromKrakow);
        System.out.println(averageSalary);
        System.out.println(numberOfWomanKrakow);
        System.out.println(numberOfMenAfter65);
        System.out.println(oldestPerson);
        System.out.println(youngestPerson);
        System.out.println(totalSalary);
        System.out.println(letterAFirstNameCheck);
        System.out.println(letterALastNameCheck);
    }
}
