package designPattern.singletonPattern;

public final class Singleton {
    public static Singleton singleton;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if(singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
