package designPattern.FacadePattern;

public class ShapeMaker {
    private Shape shape;

    public void drawCircle() {
        shape = new Circle();
        shape.draw();
    }

    public void drawRectangle() {
        shape = new Rectangle();
        shape.draw();
    }

    public void drawSquare() {
        shape = new Square();
        shape.draw();
    }
}
