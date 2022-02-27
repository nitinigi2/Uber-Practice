package src.com.java8practice;

@FunctionalInterface
interface Functional{
    void whoAmI();
    default void print(){
        System.out.println("In functional interface");
    }
}

@FunctionalInterface
interface Functional2{
    public void whoAmI();
    default void print(){
        System.out.println("In Functional2 interface");
    }
}

class TestFunc implements Functional, Functional2{

    @Override
    public void whoAmI() {
        System.out.println("whoAmI is called");
    }

    @Override
    public void print() {
        //System.out.println("I am in TestFunc class");
        Functional.super.print();
    }
}

public class functionalinterface{

    public static void main(String[] args) {
        TestFunc t = new TestFunc();
        t.whoAmI();
        t.print();

        Functional functional = () -> System.out.println("Using lambda function");
        functional.whoAmI();

        Functional functional1 = functionalinterface::printMe;
        functional1.whoAmI();
    }

    public static void printMe(){
        System.out.println("Using method reference");
    }



}
