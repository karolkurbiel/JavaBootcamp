package itacademy._11.carwinterface;

public abstract class Car {
    private final String name;
    private final String type;

    public Car(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
