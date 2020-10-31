package itacademy._8.mobilephone;

import java.util.ArrayList;
import java.util.List;

public class MobilePhone {
    private final String brand;
    private final String model;
    private final int batteryCapacity;
    private int batteryAmountLeft;
    private int memoryLeft;
    private final List<String> applicationList;

    public MobilePhone(String brand, String model, int batteryCapacity, int memory) {
        this.brand = brand;
        this.model = model;
        this.batteryCapacity = batteryCapacity;
        this.batteryAmountLeft = batteryCapacity;
        this.memoryLeft = memory;
        this.applicationList = new ArrayList<>();
    }

    public void installApplication(String name, int size) {
        if(!applicationList.contains(name.toLowerCase())) {
            if(installing(name, size)) {
                System.out.println("Application " + name + " has been installed. Remaining memory: " + memoryLeft + " MB.");
            } else {
                System.out.println("Application " + name + " failed to install. Not enough memory!");
            }
        } else {
            System.out.println("Application " + name + " has been already installed.");
        }
    }

    public void useApplication(String name, int time) {
        if(!applicationList.contains(name.toLowerCase())) {
            System.out.println("Application " + name + " not found on your " + brand + ".");
        } else {
            int demandedCapacity = time * 100;
            if(batteryAmountLeft > demandedCapacity) {
                discharging(demandedCapacity);
                System.out.println("Application " + name + " has been running for " + time + " hours. Remaining battery capacity: " + batteryAmountLeft + " mAh");
            } else if(batteryAmountLeft == demandedCapacity) {
                discharging(demandedCapacity);
                System.out.println("Application " + name + " has been running for " + time + " hours. Battery depleted.");
            } else if(batteryAmountLeft > 0) {
                int timeLeft = time - (batteryAmountLeft / 100);
                discharging(batteryAmountLeft);
                System.out.println("Application " + name + " has been running only for " + (time - timeLeft) + " hours. Battery depleted.");
            } else {
                System.out.println("Application " + name + " failed to run. Battery depleted!");
            }
        }
    }

    public void charge() {
        if(batteryCapacity != batteryAmountLeft) {
            charging();
            System.out.println(brand + " " + model + " has been fully charged. Remaining battery capacity: " + batteryAmountLeft + " mAh");
        } else {
            System.out.println(brand + " " + model + " is fully charged. Remaining battery capacity: " + batteryAmountLeft + " mAh");
        }
    }

    private void discharging(int amount) {
        this.batteryAmountLeft -= amount;
    }

    private void charging() {
        this.batteryAmountLeft = this.batteryCapacity;
    }

    private boolean installing(String name, int size) {
        if(memoryLeft >= size) {
            this.memoryLeft -= size;
            this.applicationList.add(name.toLowerCase());
            return true;
        }
        return false;
    }


}
