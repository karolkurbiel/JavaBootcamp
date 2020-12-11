package itacademy._19.lambdas;

import java.util.function.Function;

public class MainLambda {
    public static void main(String[] args) {
        String text = "love whisky";
        StringConverter converter0 = new StringConverter() {
            @Override
            public String convertString(String input) {
                return input.toUpperCase();
            }
        };
        System.out.println("1.1 to upper case:\t" + modifyString0(converter0, text));

        text = "Marianne has COMPLICATED character";
        Function<String, String> converter = input -> input.toLowerCase();
        System.out.println("1.2 to lower case:\t" + modifyString(converter, text));

        text = "Zuppa Romana";
        converter = input -> Character.toString(input.charAt(0));
        System.out.println("1.3 firs char:\t" + modifyString(converter, text));

        System.out.println("1.4 last char:\t" + modifyString(input -> Character.toString(input.charAt(input.length()-1)), text));

        System.out.println("2.1 input String length:\t" + countString(input -> input.length(), text));

        System.out.println("2.2 number of words in input String:\t" + countString(input -> input.split(" ").length, text));


    }

    public static String modifyString0(StringConverter converter,String input) {
        return converter.convertString(input);
    }

    public static String modifyString(Function<String, String> converter,String input) {
        return converter.apply(input);
    }

    public static Integer countString(Function<String, Integer> counter, String input) {
        return counter.apply(input);
    }
}
