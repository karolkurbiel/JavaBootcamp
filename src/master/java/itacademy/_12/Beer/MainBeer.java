package itacademy._12.Beer;

public class MainBeer {
    public static void main(String[] args) {
        Beer firstBottle = new Beer("Strong Beer","APA",5.8,29);
        Beer secondBottle = new Beer("Strong Beer","APA",5.8,29);
        Beer thirdBottle = new Beer("Blue Power","IPA",6.1,30.5);

        System.out.println("First " + firstBottle.hashCode() + ":");
        System.out.println("\tCompare to second: \t" + firstBottle.equals(secondBottle));
        System.out.println("\tCompare to third: \t" + firstBottle.equals(thirdBottle));

        System.out.println("Second " + secondBottle.hashCode() + ":");
        System.out.println("\tCompare to first: \t" + secondBottle.equals(firstBottle));
        System.out.println("\tCompare to third: \t" + secondBottle.equals(thirdBottle));

        System.out.println("Third " + thirdBottle.hashCode() + ":");
        System.out.println("\tCompare to second: \t" + thirdBottle.equals(secondBottle));
        System.out.println("\tCompare to first: \t" + thirdBottle.equals(firstBottle));
    }
}
