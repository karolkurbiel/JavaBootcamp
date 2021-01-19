package itacademy._12.Factorial;

public class MainFactorial {
    public static void main(String[] args) {
        for(int i = 0; i <= 10; i++) {
            System.out.println("Factorial of " + i + " equals: " + getFactorial(i));
        }
    }

    private static int getFactorial(int number) {
        if(number < 0) {
            throw new IllegalArgumentException();
        }
        if(number == 0 || number == 1) {
            return 1;
        }

        return (number * getFactorial(number-1));
    }
}
