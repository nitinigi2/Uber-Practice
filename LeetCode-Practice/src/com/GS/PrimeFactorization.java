package src.com.GS;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PrimeFactorization {
    public static List<Integer> primeFactorization(int x) {
        List<Integer> ans = new ArrayList<>();
        int limit = (int) Math.sqrt(x);
        for (int i = 2; i <= limit; i++) {
            while (x%i == 0) {
                x=x/i;
                ans.add(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int x = 12;
        System.out.println(primeFactorization(x));
    }
}
