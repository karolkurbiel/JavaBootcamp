package itacademy._23.immutableobject;

public class Wheel {
    private int radius;
    private int width;

    public Wheel(Wheel wheel) {
        this(wheel.getRadius(), wheel.getWidth());
    }

    public Wheel(int radius, int width) {
        this.radius = radius;
        this.width = width;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getRadius() {
        return radius;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public String toString() {
        return "Wheel{" +
                "radius=" + radius +
                ", width=" + width +
                '}';
    }
}
