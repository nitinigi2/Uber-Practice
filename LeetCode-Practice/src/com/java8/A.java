package src.com.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public interface A {
    String printData();
}

class TT {
    public static void main(String[] args) {
        A a = () -> "Prn";

        Supplier supplier = () -> a;

        A a1 = (A) supplier.get();

        System.out.println(a1.printData());
    }
}

class Singleton {
    private static Singleton obj = null;
    private static Object object;

    static Singleton getInstance() {
        if(obj == null) {
            synchronized (object) {
                if(obj == null) {
                    obj = new Singleton();
                }
            }
        }
        return obj;
    }
}