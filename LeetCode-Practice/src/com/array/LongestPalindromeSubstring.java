package src.com.array;

// https://leetcode.com/problems/longest-palindromic-substring/
public class LongestPalindromeSubstring {
    int start = 0, end = 0, max=0;
    public String longestPalindrome(String s) {
        int n = s.length();
        for(int i=0;i<n;i++){
            longestPal(s, i, i);
            longestPal(s, i, i+1);
        }

        return s.substring(start, end+1);
    }

    public void longestPal(String s, int i, int j){
        int n = s.length();
        if(i<0 || j>=n) return;

        while(i>=0 && j<n && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
        }

        if(max < j-i-1){
            max = j-i-1;
            start = i+1;
            end = j-1;
        }
    }
}
