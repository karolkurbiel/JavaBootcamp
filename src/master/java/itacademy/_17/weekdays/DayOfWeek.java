package itacademy._17.weekdays;

import java.util.ArrayList;
import java.util.InputMismatchException;

public enum DayOfWeek {
    MON("Monday","Poniedzialek",true),
    TUE("Tuesday","Wtorek",true),
    WED("Wednesday","Sroda",true),
    THU("Thursday","Czwartek",true),
    FRI("Friday","Piatek",true),
    SAT("Saturday","Sobota",false),
    SUN("Sunday","Niedziela",false);

    private final String englishName;
    private final String polishName;
    private final boolean workingDay;

    DayOfWeek(String englishName, String polishName, boolean workingDay) {
        this.englishName = englishName.toLowerCase();
        this.polishName = polishName.toLowerCase();
        this.workingDay = workingDay;
    }

    public String getEnglishName() {
        return englishName;
    }

    public String getPolishName() {
        return polishName;
    }

    public boolean isWorkingDay() {
        return workingDay;
    }

    public static DayOfWeek fromEnglishName(String englishName) {
        englishName = englishName.toLowerCase();
        for(DayOfWeek dayOfWeek : DayOfWeek.values()) {
            if(dayOfWeek.getEnglishName().equals(englishName)) {
                return dayOfWeek;
            }
        }
        throw new InputMismatchException("Provided name: " + englishName + " isn't a day of the week.");
    }

    public static DayOfWeek fromPolishName(String polishName) {
        polishName = polishName.toLowerCase();
        for(DayOfWeek dayOfWeek : DayOfWeek.values()) {
            if(dayOfWeek.getPolishName().equals(polishName)) {
                return dayOfWeek;
            }
        }
        throw new InputMismatchException("Provided name: " + polishName + " isn't a day of the week.");
    }

    public static boolean isWeekend(DayOfWeek day) {
        return !day.isWorkingDay();
    }

    public static ArrayList<DayOfWeek> getWeekends() {
        ArrayList<DayOfWeek> weekends = new ArrayList<>();
        for(DayOfWeek day : DayOfWeek.values()) {
            if(isWeekend(day)) {
                weekends.add(day);
            }
        }
        return weekends;
    }

    public static ArrayList<DayOfWeek> getWorkingDays() {
        ArrayList<DayOfWeek> workingDays = new ArrayList<>();
        for(DayOfWeek day : DayOfWeek.values()) {
            if(!isWeekend(day)) {
                workingDays.add(day);
            }
        }
        return workingDays;
    }
}
