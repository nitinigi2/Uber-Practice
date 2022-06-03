package cache.LRU;

public class Main {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(5);
        for (int i = 1; i <= 5; i++) {
            cache.put(i, i * 10);
        }
        cache.get(1);
        cache.put(6, 60);
        cache.put(7, 70);
        System.out.println(cache.get(2));
    }
}
