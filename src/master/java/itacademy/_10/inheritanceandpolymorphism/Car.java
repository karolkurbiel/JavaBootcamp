package itacademy._10.inheritanceandpolymorphism;

public class Car extends Transport {
    public Car(String name, int maxPassengers) {
        super(name, maxPassengers);
    }

    @Override
    public void useHorn() {
        System.out.println("Beep!");
    }
}
