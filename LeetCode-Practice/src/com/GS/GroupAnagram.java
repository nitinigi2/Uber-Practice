package src.com.GS;

import java.util.*;

public class GroupAnagram {
    public static Set<Set<String>> group(String[] words) {
        Set<Set<String>> sets = new HashSet<>();
        Map<String, List<String>> map = new HashMap<>();
        for(String s : words) {
            String key = generateKey(s);
            if(map.containsKey(key)) {
                map.get(key).add(s);
            }else{
                map.put(key, new ArrayList<>(Arrays.asList(s)));
            }
        }
        for(String key : map.keySet()) {
            sets.add(new HashSet<>(map.get(key)));
        }
        return sets;
    }

    private static String generateKey(String s) {
        StringBuilder str = new StringBuilder();
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                str.append((char)i);
                str.append(i);
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        String[] strs = {"cat", "dog", "god"};

        System.out.println(group(strs));
    }
}
