package itacademy._8.cat;

public class MainCat {
    public static void main(String[] args) {
        Cat jaroslaw = new Cat("Jaroslaw");
        jaroslaw.eat("milk");
        jaroslaw.eat("mouse");
        jaroslaw.sleep(5);
        jaroslaw.hungry();
        jaroslaw.eat("mouse");
        jaroslaw.hungry();
        jaroslaw.play("ball");
    }
}
