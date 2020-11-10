package itacademy._11.laptopcloning;

public class Drive {
    private String name;
    private DriveType TYPE;
    private int capacity;

    enum DriveType {
        SSD,
        HDD
    }

    public Drive(Drive drive) {
        this(drive.getName(), drive.getTYPE(), drive.getCapacity());
    }

    public Drive(String name, DriveType TYPE, int capacity) {
        this.name = name;
        this.TYPE = TYPE;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DriveType getTYPE() {
        return TYPE;
    }

    public void setTYPE(DriveType TYPE) {
        this.TYPE = TYPE;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return name + " " + TYPE + " " + capacity + " TB";
    }
}
