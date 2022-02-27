package src.com;

import java.util.HashSet;
import java.util.Set;

public class Test123 {
    public static int findCountOfValid(String allowed, String[] words) {
        Set<Character> set = new HashSet<>();
        int count = 0;
        for (char c : allowed.toCharArray()) {
            set.add(c);
        }

        for (String s : words) {
            int len = 0;
            for (char c : s.toCharArray()) {
                if (!set.contains(c)) {
                    break;
                } else {
                    len++;
                }
            }
            if (len == s.length()) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws java.lang.Exception {
        String s = "";
        //String[] words = {"a","b","c","ab","ac","bc","abc"};
        String count = encode(s);
        System.out.println(count);
    }

//    Write a function that transforms string into a new string. New string does not contain repeating letters but contains a number after every letter that means how many times the letter was repeated in the original string
//
//""   ->   ""
//        "aab"   ->   "a2b1"
//        "aaaabbbaab"   ->   "a4b3a2b1"

    public static String encode(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        char prev = ' ';
        int count = 0;
        for (char c : input.toCharArray()) {
            if (c != prev && prev != ' ') {
                stringBuilder.append(prev + "" + count);
                count = 1;
                prev = c;
            } else {
                count++;
                prev = c;
            }
        }
        stringBuilder.append(prev + "" + (count));
        return stringBuilder.toString();
    }
}

/*count=1 prev=b, curr=a

a4b3a2b1
a=0
        b=1*/
