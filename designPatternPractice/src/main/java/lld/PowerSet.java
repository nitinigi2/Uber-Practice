package lld;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PowerSet {
    private static List<String> ans = new ArrayList<>();

    public static void main(String[] args) {
        String s = "abc";
        generatePowerSet(s, 0, "");

        ans.stream().forEach(System.out::println);
    }

    private static void generatePowerSet(String s, int i, String curr) {
        if (i == s.length()) {
            ans.add(curr);
            return;
        }
        generatePowerSet(s, i + 1, curr + s.charAt(i));
        generatePowerSet(s, i + 1, curr);
    }
}

/* abc
 * a
 * b
 * c
 * ab
 * ac
 * bc
 * abc
 *
 * */
