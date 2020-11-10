package itacademy._11.laptopcloning;

public class Laptop {
    private String name;
    private Processor processor;
    private Drive drive;
    private double weight;
    private double screenSize;
    private int ram;

    public Laptop(Laptop laptop) {
        this(laptop.getName(), new Processor(laptop.getProcessor()), new Drive(laptop.getDrive()), laptop.getWeight(), laptop.getScreenSize(), laptop.getRam());
    }

    public Laptop(String name, Processor processor, Drive drive, double weight, double screenSize, int ram) {
        this.name = name;
        this.processor = processor;
        this.drive = drive;
        this.weight = weight;
        this.screenSize = screenSize;
        this.ram = ram;
    }

    public String getName() {
        return name;
    }

    public Processor getProcessor() {
        return processor;
    }

    public Drive getDrive() {
        return drive;
    }

    public double getWeight() {
        return weight;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public int getRam() {
        return ram;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public void setHardDrive(Drive drive) {
        this.drive = drive;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    @Override
    public String toString() {
        return name + " with " + processor + ", " + drive + ", weight: " + weight + " kg, screen size: " + screenSize + "', and with " + ram + " GB.";
    }
}
