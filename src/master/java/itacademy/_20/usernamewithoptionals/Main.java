package itacademy._20.usernamewithoptionals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    private static List<Person> personList;

    static {
        initPersonList();
    }

    public static void main(String[] args) {
        for(Person person : personList) {
            System.out.println(generateUserName(person));
        }
    }

    private static String generateUserName(Person person) {
        String s = person.getFirstName().charAt(0)
                + person.getFamilyName()
                + getBirthDate(person).orElse(LocalDate.now()).getYear();
        return s.toLowerCase();
    }

    private static Optional<LocalDate> getBirthDate(Person person) {
        return Optional.ofNullable(person.getBirthDate());
    }

    private static void initPersonList() {
        personList = new ArrayList<>();

        LocalDate birthDate = LocalDate.of(1956,5,12);
        Person person = new Person("Jan","Kowalski",birthDate);
        personList.add(person);

        birthDate = LocalDate.of(2004,8,30);
        person = new Person("Joel","Watson",birthDate);
        personList.add(person);

        person = new Person("John","Smith",null);
        personList.add(person);

        birthDate = LocalDate.of(1973,10,13);
        person = new Person("Amy","Middle",birthDate);
        personList.add(person);

        birthDate = LocalDate.of(2000,1,29);
        person = new Person("Kevin","Bushmaster",birthDate);
        personList.add(person);

        birthDate = LocalDate.of(1956,3,4);
        person = new Person("Eire","Murphy",birthDate);
        personList.add(person);

        birthDate = LocalDate.of(2017,12,23);
        person = new Person("Brendan","Walsh",birthDate);
        personList.add(person);

        birthDate = LocalDate.of(1989,7,11);
        person = new Person("Ryan","Private",birthDate);
        personList.add(person);

        person = new Person("Tomasz", "Kozien", null);
        personList.add(person);
    }
}
