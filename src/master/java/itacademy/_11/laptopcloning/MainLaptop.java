package itacademy._11.laptopcloning;

public class MainLaptop {
    public static void main(String[] args) {
        Laptop firstComputer = new Laptop("Dell",new Processor("Intel i5", 2.9,6), new Drive("Western Digital", Drive.DriveType.SSD,1),2.35,15.6,16);
        Laptop secondComputer = new Laptop(firstComputer);
        Laptop thirdComputer = createCopy(firstComputer);

        secondComputer.setName("MacBook");
        secondComputer.getProcessor().setName("M1");
        secondComputer.setWeight(1.5);
        secondComputer.getDrive().setCapacity(2);

        thirdComputer.getProcessor().setName("Intel i9");
        thirdComputer.getDrive().setTYPE(Drive.DriveType.HDD);
        thirdComputer.setWeight(3);
        thirdComputer.setRam(32);

        System.out.println("1: " + firstComputer);
        System.out.println("2: " + secondComputer);
        System.out.println("3: " + thirdComputer);
    }

    private static Laptop createCopy(Laptop laptop) {
        return new Laptop(laptop);
    }
}
