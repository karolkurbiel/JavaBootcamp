package itacademy._14.lettercounter;

import java.util.LinkedHashMap;
import java.util.Map;

public class MainCounter {
    public static void main(String[] args) {
        String input = "This is a test text";
        System.out.println(getCharacterCount(input));
    }

    private static Map<Character, Integer> getCharacterCount(String input) {
        if(input.isEmpty()) {
            throw new NullPointerException();
        }

        Map<Character, Integer> list = new LinkedHashMap<>();
        char character;
        int count;


        for(int i = 0; i < input.length(); i++) {
            character = input.charAt(i);
            if(character == ' ') {
                continue;
            }
            count = list.getOrDefault(character, 0);
            count++;
            list.put(character, count);
        }

        return list;
    }
}
