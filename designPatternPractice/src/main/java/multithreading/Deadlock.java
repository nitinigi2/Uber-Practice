package multithreading;

public class Deadlock {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "def";

        Thread thread1 = new Thread(() -> {
            synchronized (s1) {
                System.out.println(s1);
                synchronized (s2) {
                    System.out.println(s2);
                }
            }

        });
        Thread thread2 = new Thread(() -> {
            synchronized (s2) {
                System.out.println(s2);
                synchronized (s1) {
                    System.out.println(s1);
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
