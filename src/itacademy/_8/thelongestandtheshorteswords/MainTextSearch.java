package itacademy._8.thelongestandtheshorteswords;

import java.util.ArrayList;
import java.util.Collection;

public class MainTextSearch {

    public static void main(String[] args) {
        String input = "For given text find the longest and the shortest words";

        System.out.println("Shortest: " + getShortestWords(input));
        System.out.println("Longest: " + getLongestWords(input));
    }

    private static Collection<String> getShortestWords(String input) {
        String[] separatedString = input.split(" ");
        int lowestNumberOfCharacters = Integer.MAX_VALUE;
        Collection<String> shortestList = new ArrayList<>();

        for(String word : separatedString) {
            int numberOfCharacters = word.length();

            if(numberOfCharacters < lowestNumberOfCharacters) {
                shortestList.clear();
                lowestNumberOfCharacters = numberOfCharacters;
                shortestList.add(word);
            } else if(numberOfCharacters == lowestNumberOfCharacters) {
                shortestList.add(word);
            }
        }
        return shortestList;
    }

    private static Collection<String> getLongestWords(String input) {
        String[] separatedString = input.split(" ");
        int largestNumberOfCharacters = 0;
        Collection<String> longestList = new ArrayList<>();

        for(String word : separatedString) {
            int numberOfCharacters = word.length();

            if(numberOfCharacters > largestNumberOfCharacters) {
                longestList.clear();
                largestNumberOfCharacters = numberOfCharacters;
                longestList.add(word);
            } else if(numberOfCharacters == largestNumberOfCharacters) {
                longestList.add(word);
            }
        }
        return longestList;
    }
}
