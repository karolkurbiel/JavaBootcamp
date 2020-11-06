package itacademy._10.inheritanceandpolymorphism;

public class Motorbike extends Transport {
    public Motorbike(String name, int maxPassengers) {
        super(name, maxPassengers);
    }

    @Override
    public void useHorn() {
        System.out.println("pip");
    }
}
