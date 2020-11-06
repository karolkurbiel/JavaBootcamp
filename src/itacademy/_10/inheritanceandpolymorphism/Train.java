package itacademy._10.inheritanceandpolymorphism;

public class Train extends PublicTransport {
    public Train(String name, int maxPassengers) {
        super(name, maxPassengers);
    }

    @Override
    public void useHorn() {
        System.out.println("Chu Chu ... !");
    }
}
