package ITAcademy._8.CarWithEngine;

public class MainCarWithEngine {
    public static void main(String[] args) {
        Car ford = new Car("Ford Puma", new Engine("EcoBoost", 130, 2000),50);
        ford.drive(100,50);
        ford.startEngine();
        ford.startEngine();
        ford.stopEngine();
        ford.startEngine();
        ford.drive(100,50);
        ford.drive(500,50);
        ford.drive(100,200);
        ford.drive(100,50);
        ford.refuel();
        ford.drive(100,50);
    }
}
