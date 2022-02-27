package src.com.array;

public class Test2 {
    public static void main(String[] args) {
        String s = "abbad";
        solve(s, s.length());
    }

    public static boolean isPal(String s) {
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private static void solve(String s, int n) {
        for (int i = 0; i < n; i++) {
            String st = "";
            if (i != 0) {
                st = s.substring(0, i) + s.substring(i + 1);
            }
            if (isPal(st) && s.indexOf(st) != -1) {
                System.out.println(st);
            }
        }

    }
}
