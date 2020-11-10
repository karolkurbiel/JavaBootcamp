package itacademy._11.laptopcloning;

public class Processor {
    private String name;
    private double frequency;
    private int cores;

    public Processor(Processor processor) {
        this(processor.getName(), processor.getFrequency(), processor.getCores());
    }

    public Processor(String name, double frequency, int cores) {
        this.name = name;
        this.frequency = frequency;
        this.cores = cores;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getFrequency() {
        return frequency;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }

    public int getCores() {
        return cores;
    }

    public void setCores(int cores) {
        this.cores = cores;
    }

    @Override
    public String toString() {
        return name + " " + frequency + " GHz";
    }
}
