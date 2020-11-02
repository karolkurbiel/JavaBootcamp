package itacademy._9.fibonacci;

public class MainFibonacci {
    public static void main(String[] args) {
        System.out.println("The beginning of the Fibonacci Sequence: ");
        for(int i = 0; i <= 10; i++) {
            System.out.println("\t" + getFibonacci(i));
        }
    }

    private static int getFibonacci(int n) {
        if(n == 0) {
            return 0;
        } else if(n == 1 || n == 2) {
            return 1;
        }

        int f_1 = getFibonacci(n-1);
        int f_2 = getFibonacci(n-2);

        return f_1 + f_2;
    }
}
