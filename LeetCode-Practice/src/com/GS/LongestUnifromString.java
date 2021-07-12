package src.com.GS;

public class LongestUnifromString {

    public static int[] longestUniformSubstring(String input) {
        int i = 1, n = input.length();
        int start = 1;
        int maxStart = 0, maxlen = 0;
        int currLen = 0;
        char prev = input.charAt(0);
        while (i < n) {
            char current = input.charAt(i);
            if (current == prev) {
                currLen++;
            } else {
                start = i;
                prev = current;
                currLen = 1;
            }
            if (maxlen < currLen) {
                maxStart = start;
                maxlen = currLen;
            }
            i++;
        }
        return new int[] {maxStart, maxlen};
    }

    public static void main(String[] args) {
        String s = "aabbbbbCdAA";
        int[] ans = longestUniformSubstring(s);
        System.out.println(ans[0] + " " + ans[1]);
    }

}
