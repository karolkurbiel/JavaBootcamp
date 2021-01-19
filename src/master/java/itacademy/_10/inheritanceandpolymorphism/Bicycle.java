package itacademy._10.inheritanceandpolymorphism;

public class Bicycle extends Transport {
    public Bicycle(String name, int maxPassengers) {
        super(name, maxPassengers);
    }

    @Override
    public void useHorn() {
        System.out.println("Dryyyn!");
    }
}
