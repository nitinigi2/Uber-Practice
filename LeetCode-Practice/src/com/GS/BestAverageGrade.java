package src.com.GS;

import java.util.HashMap;
import java.util.Map;

public class BestAverageGrade {
    public static int bestAverageGrade(String[][] scores) {
        Map<String, Integer> map = new HashMap<>();
        for (String[] str : scores) {
            String name = str[0];
            int grade = Integer.parseInt(str[1]);
            if (map.containsKey(name)) {
                int avgGrade = (grade + map.get(name)) / 2;
                map.put(name, avgGrade);
            }else{
                map.put(name, grade);
            }
        }
        int maxGrade = 0;
        for(int grade : map.values()) {
            if(maxGrade < grade) {
                maxGrade = grade;
            }
        }
        return maxGrade;
    }

    public static void main(String[] args) {
        String[][] arr = {
                {"Sarah", "91"},
                {"Goldie", "92"},
                {"Elaine", "93"},
                {"Elaine", "95"},
                {"Goldie", "94"},
                {"Sarah", "93"}
        };
        System.out.println(bestAverageGrade(arr));

    }
}
