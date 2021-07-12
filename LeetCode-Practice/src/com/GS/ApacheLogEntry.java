package src.com.GS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class ApacheLogEntry {
    public static List<String> findTopIpaddress(String[] lines) {
        List<String> ans = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for(String s : lines) {
            String ip = s.split(" ")[0];
            if(map.containsKey(ip)){
                map.put(ip, map.get(ip)+1);
            }else {
                map.put(ip, 1);
            }
        }
        int max = 0;
        for(int value : map.values()) {
            if(max < value) {
                max = value;
            }
        }

        for(String key : map.keySet()) {
            int value = map.get(key);
            if(value == max) {
                ans.add(key);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String lines[] = new String[]{
                "10.0.0.1 - frank [10/Dec/2000:12:34:56 -0500] \"GET /a.gif HTTP/1.0\" 200 234",
                "10.0.0.1 - frank [10/Dec/2000:12:34:57 -0500] \"GET /b.gif HTTP/1.0\" 200 234",
                "10.0.0.2 - nancy [10/Dec/2000:12:34:58 -0500] \"GET /c.gif HTTP/1.0\" 200 234",
                "10.0.0.2 - nancy [10/Dec/2000:12:34:59 -0500] \"GET /c.gif HTTP/1.0\" 200 234",
                "10.0.0.3 - logan [10/Dec/2000:12:34:59 -0500] \"GET /d.gif HTTP/1.0\" 200 234"};

        List<String> strs = findTopIpaddress(lines);
        for (String s : strs) {
            System.out.println(s);
        }
    }
}
