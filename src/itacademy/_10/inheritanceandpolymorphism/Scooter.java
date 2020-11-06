package itacademy._10.inheritanceandpolymorphism;

public class Scooter extends Transport {
    public Scooter(String name, int maxPassengers) {
        super(name, maxPassengers);
    }

    @Override
    public void useHorn() {
        System.out.println("pip");
    }
}
