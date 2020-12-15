package itacademy._20.streamsandlambdas;

import java.time.LocalDate;

public class Person {
    private final String firstName;
    private final String familyName;
    private final LocalDate birthDate;
    private Gender gender;
    private int salary;
    private Address address;

    public enum Gender {
        MALE,
        FEMALE,
        OTHER
    }

    public Person(String firstName, String familyName, LocalDate birthDate, Gender gender, int salary, Address address) {
        this.firstName = firstName;
        this.familyName = familyName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.salary = salary;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public int getSalary() {
        return salary;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", familyName='" + familyName + '\'' +
                ", birthDate=" + birthDate +
                ", gender=" + gender +
                ", salary=" + salary +
                ", address=" + address +
                '}';
    }
}
