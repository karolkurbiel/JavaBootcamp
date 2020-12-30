package itacademy._23.immutableobject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class Car {
    private final String manufacturer;
    private final String model;
    private final Engine engine;
    private final List<Wheel> wheels;

    public Car(String manufacturer, String model, Engine engine, List<Wheel> wheels) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.engine = new Engine(engine.getType(), engine.getHorsePower(), engine.getVolume());
        this.wheels = new ArrayList<>(wheels);
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return new Engine(engine.getType(), engine.getHorsePower(), engine.getVolume());
    }

    public List<Wheel> getWheels() {
        return Collections.unmodifiableList(wheels);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(manufacturer, car.manufacturer) && Objects.equals(model, car.model) && Objects.equals(engine, car.engine) && Objects.equals(wheels, car.wheels);
    }

    @Override
    public int hashCode() {
        return Objects.hash(manufacturer, model, engine, wheels);
    }

    @Override
    public String toString() {
        return manufacturer + " " + model + ", engine: " + engine + ", wheels: " + wheels;
    }
}
