package itacademy._8.cat;

public class Cat {
    private final String name;
    private boolean isHungry;

    public Cat(String name) {
        this.name = name;
        this.isHungry = true;
    }

    public void hungry() {
        if(isHungry) {
            System.out.println(name + " is hungry.");
        } else {
            System.out.println(name + " is not hungry.");
        }
    }

    public void eat(String food) {
        if(isHungry) {
            System.out.println(name + " is eating " + food + ".");
            isHungry = false;
        } else {
            hungry();
        }
    }

    public void sleep(int time) {
        System.out.println(name + " is going to sleep for " + time + " hours.");
        isHungry = true;
    }

    public void play(String toy) {
        System.out.println(name + " is playing with " + toy + ".");
    }
}
