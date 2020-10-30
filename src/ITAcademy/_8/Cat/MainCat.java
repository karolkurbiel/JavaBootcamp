package ITAcademy._8.Cat;

public class MainCat {
    public static void main(String[] args) {
        Cat jaroslaw = new Cat("Jaroslaw");
        jaroslaw.eat("milk");
        jaroslaw.eat("mouse");
        jaroslaw.sleep(5);
        jaroslaw.isHungry();
        jaroslaw.eat("mouse");
        jaroslaw.isHungry();
        jaroslaw.play("ball");
    }
}
