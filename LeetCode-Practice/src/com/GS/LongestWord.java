package src.com.GS;

import java.util.HashSet;
import java.util.Set;

// Time complexity - O(n*m)
// m is the length of longest string, n in no. of input
// Space complexity - O(n)
public class LongestWord {
    public static Set<String> longestWord(String letter, String[] dictionary){
        Set<Character> letterSet = new HashSet<>();
        Set<String> longestWords = new HashSet<>();
        String currentLongestWord = "";
        String lastLongestWord = "";
        for(char c : letter.toCharArray()) {
            letterSet.add(c);
        }

        for(String word : dictionary) {
            if(areLettersInWord(word, letterSet)){
                if(currentLongestWord.length() <= word.length()) {
                    lastLongestWord = currentLongestWord;
                    currentLongestWord = word;
                }

                if(!longestWords.contains(currentLongestWord) && lastLongestWord.length() < currentLongestWord.length()) {
                    longestWords.clear();
                }
                longestWords.add(currentLongestWord);
            }
        }
        return longestWords;
    }

    private static boolean areLettersInWord(String word, Set<Character> letterSet) {
        for(char c : word.toCharArray()){
            if(!letterSet.contains(c)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] dictionary = {"to", "toe", "toes", "doe", "dog", "god", "dogs", "book", "banana"};
        String word = "oetdg";

        System.out.println(longestWord(word, dictionary));
    }
}
