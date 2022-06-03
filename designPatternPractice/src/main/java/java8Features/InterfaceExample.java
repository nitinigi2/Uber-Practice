package java8Features;

public class InterfaceExample implements A2 {

    @Override
    public void show() {
        System.out.println("Hi i am show");
    }

    @Override
    public void printMe() {
        A2.super.printMe();
        System.out.println("Hello it's new printMe");
    }
}

interface A1 {
    void show();

    default void printMe() {
        System.out.println("Print me is called from A1");
    }
}

interface A2 extends A1 {
    default void printMe() {
        A1.super.printMe();
        System.out.println("Print me is called from A2");
    }
}

class Main {
    public static void main(String[] args) {
        InterfaceExample interfaceExample = new InterfaceExample();
        interfaceExample.printMe();
        interfaceExample.show();
    }
}