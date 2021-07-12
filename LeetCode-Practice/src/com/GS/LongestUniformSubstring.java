package src.com.GS;

// Time complexity - O(n)
// space complexity - O(1)

public class LongestUniformSubstring {

    public static int[] longestUniformSubstring(String input) {
        int prevStartIndex = 0, prevEndIndex = 0, currStartIndex = 0, currEndIndex = 0;
        char prev = input.charAt(0);
        int n = input.length();

        for (int i = 1; i < n; i++) {
            char currChar = input.charAt(i);
            if (currChar == prev) {
                currEndIndex = i;
            } else {
                if (currEndIndex - currStartIndex > prevEndIndex - prevStartIndex) {
                    prevStartIndex = currStartIndex;
                    prevEndIndex = currEndIndex-1;
                }
                currStartIndex = i;
                currEndIndex = i;
                prev = currChar;
            }
        }

        if (currEndIndex - currStartIndex > prevEndIndex - prevStartIndex) {
            prevStartIndex = currStartIndex;
            prevEndIndex = currEndIndex;
        }

        return new int[]{prevStartIndex, prevEndIndex};
    }

    public static void main(String[] args) {
        String str = "aabbbbbCdAA";
        int[] ans = longestUniformSubstring(str);
        System.out.println(ans[0] + " " + ans[1]);
    }
}
