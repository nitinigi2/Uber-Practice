package src.com.GS;

// Time complexity - O(n)
// Space complexity - O(1)
public class FirstNonRepeatingChar {

    public static char findFirst(String input) {
        int[] freq = new int[26];
        for(char c : input.toCharArray()) {
            freq[c-'a']++;
        }

        for(char c : input.toCharArray()) {
            if(freq[c-'a'] == 1) {
                return c;
            }
        }
        return '0';
    }

    public static void main(String[] args) {
        String str = "xxyyzz";
        char repeatedChar = findFirst(str);
        System.out.println(repeatedChar);
    }
}
