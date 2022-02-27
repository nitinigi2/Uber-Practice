package src.com.java8;

interface I1{
    void display(String s);
}
public class MethodReference {
    public MethodReference(String s){
        System.out.println("Sjdkw: " + s);
    }
    // static method reference
    public void show(String s){
        System.out.println("Showing something " + s);
    }

    public static void main(String[] args) {
        //MethodReference methodReference = new MethodReference();
        I1 i1 = MethodReference :: new;
        i1.display("abcd");
    }
}
