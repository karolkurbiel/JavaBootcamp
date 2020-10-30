package itacademy._8.mobilephone;

import java.util.ArrayList;
import java.util.List;

public class MobilePhone {
    private final String brand;
    private final String model;
    private final int batteryCapacity;
    private int batteryAmountLeft;
//    private final int memory;
    private int memoryLeft;
    private final List<String> applicationList;

    public MobilePhone(String brand, String model, int batteryCapacity, int memory) {
        this.brand = brand;
        this.model = model;
        this.batteryCapacity = batteryCapacity;
//        this.memory = memory;

        this.batteryAmountLeft = batteryCapacity;
        this.memoryLeft = memory;
        this.applicationList = new ArrayList<>();
    }

    public void installApplication(String name, int size) {
        if(!applicationList.contains(name.toLowerCase())) {
            if(install(name, size)) {
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
            System.out.println("Application " + name + " not found in your " + this.brand + ".");
        } else {
            int run = discharging(time);
            if(run == 0) {
                System.out.println("Application " + name + " has been running for " + time + " hours. Battery status: " + batteryPercent() + "%");
            } else if(run == -1) {
                System.out.println("Application " + name + " has been running for " + time + " hours. Battery depleted.");
            } else if(run > 0){
                System.out.println("Application " + name + " has been running only for " + (time - run) + " hours. Battery depleted.");
            } else {
                System.out.println("Application " + name + " failed to run. Battery depleted!");
            }
        }
    }

    public void charge() {
        if(charging()) {
            System.out.println(brand + " " + model + " has been fully charged. Battery status: " + batteryPercent() + "%");
        } else {
            System.out.println(brand + " " + model + " is fully charged. Battery status: " + batteryPercent() + "%");
        }
    }

    private int discharging(int time) {
        // returns 0  : application runtime completed, battery capacity updated
        // returns -1 : application runtime completed, battery discharged
        // returns -2 : application cannot be run, battery depleted.
        // returns >0 : application runtime not completed, hours left to complete

        if(batteryAmountLeft == 0) {
            return -2;
        }

        int amountToConsume = time * 100;
        if(this.batteryAmountLeft > amountToConsume) {
            this.batteryAmountLeft -= amountToConsume;
            return 0;
        }

        int hoursLeft = batteryAmountLeft / 100;
        this.batteryAmountLeft = 0;
        if(time == hoursLeft) {
            return -1;
        } else {
            return time - hoursLeft;
        }
    }

    private int batteryPercent() {
        // returns percentage of battery

        return ((100*batteryAmountLeft)/batteryCapacity);
    }

    private boolean charging() {
        // updates batteryAmount to its initial condition specified in batteryCapacity

        if(batteryCapacity != batteryAmountLeft) {
            this.batteryAmountLeft = this.batteryCapacity;
            return true;
        }
        return false;
    }

    private boolean install(String name, int size) {
        // updates memoryLeft after "installation"

        if(memoryLeft >= size) {
            this.memoryLeft -= size;
            this.applicationList.add(name.toLowerCase());
            return true;
        }
        return false;
    }


}
