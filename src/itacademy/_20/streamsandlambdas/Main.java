package itacademy._20.streamsandlambdas;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static final List<Person> personList = new ArrayList<>();

    static {
        initPersonList();
    }

    public static void main(String[] args) {
        List<Person> under65list = personList.stream()
                .filter(person -> person.getBirthDate().isAfter(LocalDate.now().minus(65, ChronoUnit.YEARS)))
                .filter(person -> person.getGender().equals(Person.Gender.MALE))
                .sorted(Comparator.comparing(Person::getFamilyName))
                .collect(Collectors.toList());

        List<Person> womenSalaryList = personList.stream()
                .filter(person -> person.getGender().equals(Person.Gender.FEMALE))
                .filter(person -> (person.getSalary() < 5000))
                .sorted(Comparator.comparing(Person::getFamilyName))
                .collect(Collectors.toList());

        List<Person> peopleFromKrakow = personList.stream()
                .filter(person -> person.getBirthDate().isAfter(LocalDate.now().minus(18, ChronoUnit.YEARS)))
                .filter(person -> person.getAddress().getCity().equals("Krakow"))
                .sorted(Comparator.comparing(Person::getFamilyName))
                .collect(Collectors.toList());

        List<Person> peopleNotFromKrakow = personList.stream()
                .filter(person -> !person.getAddress().getCity().equals("Krakow"))
                .sorted(Comparator.comparing(Person::getFamilyName).reversed())
                .collect(Collectors.toList());

        System.out.println("4.1 Men under 65 years: " + "\n\t" + under65list);
        System.out.println("4.2 Women with salary less than 5000: " + "\n\t" + womenSalaryList);
        System.out.println("4.3 People younger than 18 years and from Krakow: " + "\n\t" + peopleFromKrakow);
        System.out.println("4.4 People not from Krakow" + "\n\t" +peopleNotFromKrakow);

//        +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

        OptionalDouble averageSalary = personList.stream()
                .map(Person::getSalary)
                .mapToInt(x -> x)
                .average();

        long numberOfWomenInKrakow = personList.stream()
                .filter(person -> person.getAddress().getCity().equals("Krakow"))
                .filter(person -> person.getGender().equals(Person.Gender.FEMALE))
                .count();

        long numberOfMenAfter65 = personList.stream()
                .filter(person -> person.getBirthDate().isBefore(LocalDate.now().minus(65, ChronoUnit.YEARS)))
                .count();

        Optional<Person> oldestPerson = personList.stream()
                .max(Comparator.comparing(Person::getBirthDate));

        Optional<Person> youngestPersonFromKrakow = personList.stream()
                .filter(person -> person.getAddress().getCity().equals("Krakow"))
                .min(Comparator.comparing(Person::getBirthDate));

        int totalSalary = personList.stream()
                .mapToInt(Person::getSalary)
                .sum();

        System.out.println("5.1 Average salary: " + "\n\t" + (averageSalary.isPresent() ? String.format("%.2f",averageSalary.getAsDouble()) : "Proceeded list is empty"));
        System.out.println("5.2 Number of women in Krakow: " + "\n\t" + numberOfWomenInKrakow);
        System.out.println("5.3 Number of men older than 65 years: " + "\n\t" + numberOfMenAfter65);
        System.out.println("5.4 Oldest person: " + "\n\t" + (oldestPerson.isPresent() ? oldestPerson.get() : "Proceeded list is empty"));
        System.out.println("5.5 Youngest person  from Krakow: " + "\n\t" + (youngestPersonFromKrakow.isPresent() ? youngestPersonFromKrakow.get() : "Not found people from Krakow"));
        System.out.println("5.6 Total salary count: " + "\n\t" + totalSalary);

        //        +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

        boolean under65_anyHasFirstA = under65list.stream()
                .anyMatch(person -> person.getFirstName().startsWith("A"));
        boolean womenWithSalary_anyHasFirstA = womenSalaryList.stream()
                .anyMatch(person -> person.getFirstName().startsWith("A"));
        boolean peopleFromKrakow_anyHasFirstA = peopleFromKrakow.stream()
                .anyMatch(person -> person.getFirstName().startsWith("A"));
        boolean peopleNotFromKrakow_anyHasFirstA = peopleNotFromKrakow.stream()
                .anyMatch(person -> person.getFirstName().startsWith("A"));

        boolean under65_allHasAnyA = under65list.stream()
                .allMatch(person -> person.getFamilyName().contains("a"));
        boolean womenWithSalary_allHasAnyA = womenSalaryList.stream()
                .allMatch(person -> person.getFamilyName().contains("a"));
        boolean peopleFromKrakow_allHasAnyA = peopleFromKrakow.stream()
                .allMatch(person -> person.getFamilyName().contains("a"));
        boolean peopleNotFromKrakow_allHasAnyA = peopleNotFromKrakow.stream()
                .allMatch(person -> person.getFamilyName().contains("a"));

        System.out.println("6.1.1 Any person name starts with \"A\" in under65list: " + under65_anyHasFirstA);
        System.out.println("6.1.2 Any person name starts with \"A\" in womenSalaryList: " + womenWithSalary_anyHasFirstA);
        System.out.println("6.1.3 Any person name starts with \"A\" in peopleFromKrakow: " + peopleFromKrakow_anyHasFirstA);
        System.out.println("6.1.4 Any person name starts with \"A\" in peopleNotFromKrakow: " + peopleNotFromKrakow_anyHasFirstA);

        System.out.println("6.2.1 All persons family name contains \"a\" in under65list: " + under65_allHasAnyA);
        System.out.println("6.2.2 All persons family name contains \"a\" in womenSalaryList: " + womenWithSalary_allHasAnyA);
        System.out.println("6.2.3 All persons family name contains \"a\" in peopleFromKrakow: " + peopleFromKrakow_allHasAnyA);
        System.out.println("6.2.4 All persons family name contains \"a\" in peopleNotFromKrakow: " + peopleNotFromKrakow_allHasAnyA);
    }

    private static void initPersonList() {
        Address address = new Address("Kasprusie 14","Zakopane",34500,"Poland");
        LocalDate birthDate = LocalDate.of(1948,5,28);
        personList.add(new Person("Ryszard","Bachleda", birthDate, Person.Gender.MALE,3500, address));

        address = new Address("Holbeinstraße 8/2","Augsburg",86150,"Germany");
        birthDate = LocalDate.of(1973,1,16);
        personList.add(new Person("Hans","Bauer",birthDate, Person.Gender.MALE, 5000,address));

        address = new Address("1 Warren Cres","Sligo",0,"Ireland");
        birthDate = LocalDate.of(1998,11,21);
        personList.add(new Person("Lorraine","Sheridan",birthDate, Person.Gender.FEMALE, 2000,address));

        address = new Address("2905 Madison Ave N","Fargo, ND",58102,"USA");
        birthDate = LocalDate.of(1966,4,30);
        personList.add(new Person("Lester","Nygaard",birthDate, Person.Gender.MALE, 1500,address));

        address = new Address("4546 White Oak Ave","Encino, CA",91316,"USA");
        birthDate = LocalDate.of(1995,4,1);
        personList.add(new Person("Logan","Paul",birthDate, Person.Gender.MALE, 8000,address));

        address = new Address("Via Pietro Trinchera 2/7","Napoli",80139,"Italy");
        birthDate = LocalDate.of(1999,6,13);
        personList.add(new Person("Francesca","Chillemi",birthDate, Person.Gender.FEMALE, 3000,address));
    }
}
