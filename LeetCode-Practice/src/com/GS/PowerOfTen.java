package src.com.GS;

public class PowerOfTen {
    private static boolean isPowerOf10(int n) {
        while (n != 1) {
            if (n % 10 != 0) return false;
            n = n / 10;
        }
        return true;
    }

    public static void main(String[] args) {
        int x = 200;
        System.out.println(isPowerOf10(x));
    }
}
