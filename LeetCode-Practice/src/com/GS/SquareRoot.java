package src.com.GS;

public class SquareRoot {
    public static void main(String[] args) {
        int x = 5;
        System.out.println(sqrt(x));
    }

    private static double sqrt(double x) {
        double low = 0, high = x;

        while (low <= high) {
            double mid = (low + high) / 2d;
            System.out.println(low + " " + high + " " + mid);
            if (mid * mid == x) {
                return mid;
            }
            if ((mid * mid < x) && ((mid + 1) * (mid + 1) > x)) {
                return findSqrt(mid+1, mid, x);
            }
            if (mid * mid > x) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    private static double findSqrt(double j, double i, double x) {
        double mid = (i + j) / 2;
        double mul = mid * mid;
        if (mul == x || Math.abs(mul - x) < 0.00000000001) {
            return mid;
        }
        if(mul < x) {
            return findSqrt(j, mid, x);
        }
        return findSqrt(mid, i, x);
    }
}
