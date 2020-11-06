package itacademy._10.inheritanceandpolymorphism;

public class Tram extends PublicTransport {
    public Tram(String name, int maxPassengers) {
        super(name, maxPassengers);
    }

    @Override
    public void useHorn() {
        System.out.println("Drrrrrrrrrrrrr!");
    }
}
