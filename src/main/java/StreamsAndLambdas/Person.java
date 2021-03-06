package StreamsAndLambdas;

import java.time.LocalDate;
import java.util.Optional;

public class Person {
    protected String firstName;
    protected String lastName;
    protected LocalDate birthDay;
    protected Sex sex;
    protected int salary;
    protected Address address;

    public Person(String firstName, String lastName, LocalDate birthDay, Sex sex, int salary, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.sex = sex;
        this.salary = salary;
        this.address = address;
    }

    protected int getAge(){
        return 2021 - birthDay.getYear();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public int getSalary() {
        return salary;
    }

    public Address getAddress() {
        return address;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDay=" + birthDay +
                ", sex=" + sex +
                ", salary=" + salary +
                ", address=" + address +
                '}';
    }

    protected static String generateUserName(Person person){
        Optional<LocalDate> dateOptional = Optional.ofNullable(person.birthDay);
        if(dateOptional.isPresent()){
            return person.firstName.toLowerCase().charAt(0) + person.lastName.toLowerCase() + person.birthDay.getYear();
        }
        return person.firstName.toLowerCase().charAt(0) + person.lastName.toLowerCase() + LocalDate.now().getYear();
    }

}
