package itacademy._10.inheritanceandpolymorphism;

public class Bus extends PublicTransport {
    public Bus(String name, int maxPassengers) {
        super(name, maxPassengers);
    }

    @Override
    public void useHorn() {
        System.out.println("Beeeeeeeeeeeeeeeeeeeeep!");
    }
}
