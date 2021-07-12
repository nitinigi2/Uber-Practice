package src.com.GS;

import java.util.HashMap;
import java.util.Map;

public class DecimalConversion {
    public static String fractionToDecimal(int numerator, int denominator) {
        StringBuilder str = new StringBuilder();
        String sign = "";

        if (numerator <= 0 && denominator < 0) {
            sign = "";
        } else if (denominator < 0 || numerator < 0) {
            sign = "-";
        }

        int div = numerator / denominator;
        int rem = numerator % denominator;
        str.append(sign);
        str.append(div);

        if (rem == 0) {
            return str.toString();
        }

        str.append(".");
        Map<Integer, Integer> map = new HashMap<>();
        while (rem != 0) {
            if(!map.containsKey(rem)) {
                map.put(rem, str.length());
            }else{
                return str.substring(0, map.get(rem)) + "(" + str.substring(map.get(rem)) + ")";
            }
            rem = rem * 10;
            str.append(rem/denominator);
            rem = rem % denominator;
        }
        return str.toString();
    }

    public static void main(String[] args) {
        int numerator = 1, denominator = 2;

        System.out.println(fractionToDecimal(numerator, denominator));
    }
}

//11/3 = 3.
//11%3 = 2