package cache.LRU;

public class DLinkNode {
    int key;
    int value;
    DLinkNode pre;
    DLinkNode post;

    public DLinkNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
