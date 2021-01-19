package itacademy._20.usernamewithoptionals;

import java.time.LocalDate;

public class Person {
    private final String familyName;
    private final String firstName;
    private final LocalDate birthDate;

    public Person(String firstName, String familyName, LocalDate birthDate) {
        this.firstName = firstName;
        this.familyName = familyName;
        this.birthDate = birthDate;
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
}
