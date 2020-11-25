package itacademy._14.partscatalogue;

import java.util.Objects;

public class CarPart implements Comparable<CarPart>{
    private final int partNumber;
    private final String name;
    private final String brand;

    public CarPart(int partNumber, String name, String brand) {
        this.partNumber = partNumber;
        this.name = name;
        this.brand = brand;
    }

    public int getPartNumber() {
        return partNumber;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public String toString() {
        return brand + ": " + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarPart carPart = (CarPart) o;
        return partNumber == carPart.partNumber &&
                Objects.equals(name, carPart.name) &&
                Objects.equals(brand, carPart.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(partNumber, name, brand);
    }

    @Override
    public int compareTo(CarPart o) {
        return Integer.compare(partNumber, o.getPartNumber());
    }
}
