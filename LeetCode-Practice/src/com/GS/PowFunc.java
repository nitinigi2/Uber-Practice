package src.com.GS;

public class PowFunc {
    public static double pow(int x, int y) {
        if (y == 0) {
            return 1;
        }
        double temp = pow(x, y / 2);

        if (y % 2 == 0) {
            return temp * temp;
        } else {
            if (y > 0) {
                return temp * temp * x;
            } else {
                return temp * temp / x;
            }
        }
    }

    public static void main(String[] args) {
        int x = 3;
        int y= 5;

        System.out.println(pow(x, y));
    }
}
