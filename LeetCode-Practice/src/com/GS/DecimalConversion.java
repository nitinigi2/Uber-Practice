package src.com.GS;

import java.util.HashMap;
import java.util.Map;

public class DecimalConversion {
    public static String fractionToDecimal(int numerator, int denominator) {
        StringBuilder result = new StringBuilder();
        String sign = "";
        if(denominator <=0 && numerator <=0) {
            sign = "";
        }else if(denominator<0 || numerator <0) {
            sign = "-";
        }

        int num = Math.abs(numerator);
        int den = Math.abs(denominator);
        result.append(sign);
        result.append(num / den);
        long rem = num % den;
        if (rem == 0)
            return result.toString();
        result.append(".");
        Map<Long, Integer> map = new HashMap();
        while(rem != 0){
            if(!map.containsKey(rem)){
                map.put(rem, result.length());
            }else {
                int idx = map.get(rem);
                return result.substring(0, idx)+"("+result.substring(idx)+")";
            }
            rem*= 10;
            result.append(rem/den);
            rem = rem%den;
        }
        System.out.println(map);
        return result.toString();
    }

    public static void main(String[] args) {
        int numerator = 2, denominator = 3;

        System.out.println(fractionToDecimal(numerator, denominator));
    }
}
