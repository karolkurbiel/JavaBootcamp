package itacademy._17.weekdays;

import java.util.InputMismatchException;

public class MainWeekDays {
    public static void main(String[] args) {
        System.out.println(DayOfWeek.fromEnglishName("monday"));
        System.out.println(DayOfWeek.fromEnglishName("friday"));
        try {
            System.out.println(DayOfWeek.fromEnglishName("asd"));
        } catch(InputMismatchException e) {
            System.out.println(e);
        }

        System.out.println("---");

        System.out.println(DayOfWeek.fromPolishName("poNIEdziaLEK"));
        System.out.println(DayOfWeek.fromPolishName("sroda"));

        System.out.println("---");

        System.out.println(DayOfWeek.getWorkingDays());
        System.out.println(DayOfWeek.getWeekends());
    }
}
