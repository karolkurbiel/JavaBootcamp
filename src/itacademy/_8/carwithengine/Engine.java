package itacademy._8.carwithengine;

public class Engine {

    private final String type;
    private final int horsePower;
    private final int capacity;
    private boolean running;

    public Engine(String type, int horsePower, int capacity) {
        this.type = type;
        this.horsePower = horsePower;
        this.capacity = capacity;
        this.running = false;
    }

    public boolean isRunning() {
        return running;
    }

    public String getType() {
        return type;
    }

    public int producedSpeed(int speed) {
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
        if(!running) {
            running = true;
            return true;
        }
        return false;
    }

    public boolean stop() {
        if(running) {
            running = false;
            return true;
        }
        return false;
    }
}
