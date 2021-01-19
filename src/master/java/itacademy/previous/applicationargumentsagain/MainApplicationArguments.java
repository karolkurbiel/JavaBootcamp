package itacademy.previous.applicationargumentsagain;

public class MainApplicationArguments {
    public static void main(String[] args) {

        for(int i = (args.length-1); i >= 0; i--) {
            System.out.print(args[i] + " ");
        }
    }
}
