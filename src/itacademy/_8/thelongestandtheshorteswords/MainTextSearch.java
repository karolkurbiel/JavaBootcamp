package itacademy._8.thelongestandtheshorteswords;

import java.util.ArrayList;
import java.util.List;

public class MainTextSearch {

    public static void main(String[] args) {
        String input = "For given text find the longest and the shortest words";

        System.out.println("Shortest: " + getList(input, false).toString());
        System.out.println("Longest: " + getList(input, true).toString());
    }



    private static List<String> getList(String input, boolean longest) {

        String[] dictionary = input.split(" ");         //splits String into array of Strings

        int sum = 0;
        int sum1 = Integer.MAX_VALUE;                        //assigned maximum value of integer for comparison

        List<String> list = new ArrayList<>();

        for(String word : dictionary) {
            int count = word.length();                      //number of characters in every word from initial String

            if(longest) {                                   //checks if we are looking for longest or shortest String
                if(count > sum) {
                    list.clear();                           //found new shortest so previous list is no longer valid
                    sum = count;                            //new limit for comparison
                    list.add(word);                         //creates new list of shortest words from initial String sentence
                } else if(count == sum) {
                    list.add(word);                         //same number of characters as in previous comparison
                }
            } else {
                if(count < sum1) {
                    list.clear();
                    sum1 = count;
                    list.add(word);
                } else if(count == sum1) {
                    list.add(word);
                }
            }
        }

        return list;
    }
}
