package itacademy._23.immutableobject;

public class Engine {
    private String type;
    private int horsePower;
    private double volume;


    public Engine(String type, int horsePower, double volume) {
        this.type = type;
        this.horsePower = horsePower;
        this.volume = volume;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public String getType() {
        return type;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public double getVolume() {
        return volume;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "type='" + type + '\'' +
                ", horsePower=" + horsePower +
                ", volume=" + volume +
                '}';
    }
}
