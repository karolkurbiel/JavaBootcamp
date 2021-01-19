package itacademy.previous.inputcheck;

import java.util.Scanner;

public class MainInputCheck {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Type exit to quit application");
        String input;
        do {
            input = scanner.nextLine();
        } while(!input.equalsIgnoreCase("exit"));
    }
}
