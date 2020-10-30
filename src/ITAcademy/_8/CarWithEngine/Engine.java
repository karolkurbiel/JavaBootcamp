package ITAcademy._8.CarWithEngine;

public class Engine {

    private final String type;
    private final int horsePower;
    private final int capacity;
    private boolean isStarted;

    public Engine(String type, int horsePower, int capacity) {
        this.type = type;
        this.horsePower = horsePower;
        this.capacity = capacity;
        this.isStarted = false;
    }

    public boolean isStarted() {
        return isStarted;
    }

    public String getType() {
        return type;
    }

    public int speedLimit(int speed) {
        //returns car speed produced by engine
        double topSpeed = horsePower/0.5;

        if(topSpeed >= speed) {
            return speed;
        } else {
            return (int)topSpeed;
        }
    }

    public double consumption() {
        //returns required fuel to travel 1 distance
        return (capacity/10000.0);
    }

    public boolean start() {
        if(!isStarted) {
            switchState();
            return true;
        }
        return false;
    }

    public boolean stop() {
        if(isStarted) {
            switchState();
            return true;
        }
        return false;
    }

    private void switchState() {
        //switches state isStarted when called
        this.isStarted ^= true;
    }
}
