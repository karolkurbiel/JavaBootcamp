package itacademy._10.inheritanceandpolymorphism;

public abstract class Transport {
    private final String name;
    private final int maxPassengers;

    public Transport(String name, int maxPassengers) {
        this.name = name;
        this.maxPassengers = maxPassengers;
    }

    protected void useHorn() {
    }

    @Override
    public String toString() {
        return name + " which can take " + maxPassengers + (maxPassengers == 1 ? " passenger" : " passengers") +" on board";
    }
}
