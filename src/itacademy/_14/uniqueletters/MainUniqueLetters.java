package itacademy._14.uniqueletters;

import java.util.LinkedHashSet;
import java.util.Set;

public class MainUniqueLetters {
    public static void main(String[] args) {
        String input = "This is a text";
        System.out.println(getUniqueLetters(input));
    }

    private static Set<Character> getUniqueLetters(String input) {
        Set<Character> output = new LinkedHashSet<>();
        Character character;
        for(int i = 0; i < input.length(); i++) {
            character = input.charAt(i);
            if(character.equals(' ')) {
                continue;
            }
            output.add(character);
        }
        return output;
    }
}
