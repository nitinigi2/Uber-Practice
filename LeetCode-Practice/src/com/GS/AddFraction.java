package src.com.GS;

public class AddFraction {
    public static int[] addFractions(int[] fraction1, int[] fraction2) {
        int[] ans = new int[2];

        int denominator = LCM(fraction1[1], fraction2[1]);
        ans[0] = numenator(fraction1, denominator) + numenator(fraction2, denominator);
        ans[1] = denominator;

        return ans;
    }

    private static int numenator(int[] fraction, int denominator) {
        return fraction[0] * (denominator / fraction[1]);
    }

    private static int LCM(int x, int y) {
        return (x*y)/GCD(x, y);
    }

    private static int GCD(int x, int y) {
        if (y == 0)
            return x;
        return GCD(y, x % y);
    }

    public static void main(String[] args) {
        int[] fraction1 = {2, 3};

        int[] fraction2 = {1, 2};

        int[] ans = addFractions(fraction1, fraction2);
        System.out.println(ans[0] + " " + ans[1]);
    }
}
