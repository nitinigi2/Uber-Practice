package designPattern.factoryPattern;

public class FactoryDemo {

    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();
        Shape shape = factory.getShape("Circle");
        shape.draw();
    }
}
