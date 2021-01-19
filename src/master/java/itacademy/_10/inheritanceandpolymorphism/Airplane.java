package itacademy._10.inheritanceandpolymorphism;

public class Airplane extends PublicTransport {
    public Airplane(String name, int maxPassengers) {
        super(name, maxPassengers);
    }

    @Override
    public void useHorn() {
        System.out.println("No one will hear me in the sky.");
    }
}
