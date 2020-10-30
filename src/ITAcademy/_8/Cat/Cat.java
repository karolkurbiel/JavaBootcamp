package ITAcademy._8.Cat;

public class Cat {
    private final String name;
    private boolean isHungry;

    public Cat(String name) {
        this.name = name;
        this.isHungry = true;
    }

    public void isHungry() {
        if(this.isHungry) {
            System.out.println(this.name + " is hungry.");
        } else {
            System.out.println(this.name + " is not hungry.");
        }
    }

    public void eat(String food) {
        if(this.isHungry) {
            System.out.println(this.name + " is eating " + food + ".");
            this.isHungry = false;
        } else {
            isHungry();
        }
    }

    public void sleep(int time) {
        System.out.println(this.name + " is going to sleep for " + time + " hours.");
        this.isHungry = true;
    }

    public void play(String toy) {
        System.out.println(this.name + " is playing with " + toy + ".");
    }
}
