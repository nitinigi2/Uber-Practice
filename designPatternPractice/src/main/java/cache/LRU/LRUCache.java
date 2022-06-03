package cache.LRU;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private Map<Integer, DLinkNode> cache;
    private int capacity;
    private DLinkNode head = new DLinkNode(0, 0);
    private DLinkNode tail = new DLinkNode(0, 0);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        head.post = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
        DLinkNode node = cache.get(key);
        removeNode(node);
        addNode(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            DLinkNode node = cache.get(key);
            node.value = value;
            cache.put(key, node);
            return;
        }
        if (cache.size() == capacity) { // cache is full, remove last entry from cache.
            removeNode(tail.pre);
            cache.remove(tail.pre.key);
        }
        DLinkNode newNode = new DLinkNode(key, value);
        addNode(newNode);
        cache.put(key, newNode);
        printCache();
    }

    public void printCache() {
        System.out.println("#########################");
        System.out.println("Cache size: " + cache.size());
        for (Map.Entry<Integer, DLinkNode> entry : cache.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue().value);
        }
    }

    /**
     * @param node always add new node after head
     */
    private void addNode(DLinkNode node) {
        node.pre = head;
        node.post = head.post;
        head.post.pre = node;
        head.post = node;
    }

    /**
     * @param node Remove node from linked list
     */
    private void removeNode(DLinkNode node) {
        DLinkNode pre = node.pre;
        DLinkNode next = node.post;
        pre.post = next;
        next.pre = pre;
    }
}
