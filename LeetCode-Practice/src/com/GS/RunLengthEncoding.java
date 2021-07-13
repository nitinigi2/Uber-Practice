package src.com.GS;

import java.util.ArrayList;
import java.util.List;

public class RunLengthEncoding {
    private static String rle(String input) {
        int n = input.length();
        StringBuilder str = new StringBuilder();
        char prev = input.charAt(0);
        int freq = 1;
        for (int i = 1; i < n; i++) {
            char curr = input.charAt(i);
            if (curr == prev) {
                freq++;
            } else {
                str.append(prev);
                str.append(freq);
                freq = 1;
                prev = curr;
            }
        }
        str.append(prev);
        str.append(freq);
        return str.toString();
    }

    private static String findMissingLetters(String s) {
        StringBuilder ans = new StringBuilder();
        int[] freq = new int[26];
        s = s.toLowerCase();

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0) {
                ans.append((char) (i + 'a'));
            }
        }
        return ans.toString();
    }

    private static int magicPotion(String s) {
        int n = s.length();
        String prev = s.charAt(0) + "";
        int len = n;
        for (int i = 1; i < n; i++) {
            String curr = s.charAt(i) + "";
            if (prev.equals(curr)) len--;
            if ((prev.charAt(0) + "").equals(curr)) {
                int matchedLen = expand(prev, i, s);
                i += matchedLen;
                if (matchedLen != 0)
                    len -= matchedLen - 1;
            }
            prev = prev + curr;
        }
        return len;
    }

    private static int expand(String prev, int index, String s) {
        System.out.println(prev + " " + index);
        int i = 0, j = index;
        while (i < prev.length() && j < s.length()) {
            if (prev.charAt(i) != s.charAt(j)) {
                return 0;
            }
            i++;
            j++;
        }
        return prev.length();
    }

    public int minimalSteps(String ingredients) {
        int n = ingredients.length();
        if(n==0) return 0;
        StringBuilder sb = new StringBuilder();
        sb.append(ingredients.charAt(0));
        for(int i=1;i<n;i++) {
            if(i*2 <= n) {
                String str = ingredients.substring(0, i);
                if(str.equals(ingredients.substring(i, 2*i))) {
                    sb.append("*");
                    i = 2*i-1;
                }
                else {
                    sb.append(ingredients.charAt(i));
                }
            } else {
                sb.append(ingredients.charAt(i));
            }
        }
        System.out.println(sb.toString());
        return sb.length();
    }

    private static int pascal(int col, int row) {
        List<Integer> prev = new ArrayList<>();
        int count=0;
        for (int i = 0; i <= row; i++) {
            List<Integer> list = new ArrayList<>();
            count++;
            for (int j = 0; j < count; j++) {
                if (j == 0 || j == count - 1) {
                    list.add(1);
                }else {
                    int curr = prev.get(j-1) + prev.get(j);
                    list.add(curr);
                }
                if(i == row && j == col) {
                    return list.get(list.size()-1);
                }
            }
            prev = list;
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "ABCDABCE";
        //System.out.println(magicPotion(s));
        System.out.println(pascal(4, 8));
    }
}
//row=2
//col=1
//
//prev = [1, 1]
//curr = [1, 2]


