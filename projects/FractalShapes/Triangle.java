import java.awt.*;

public class Triangle {
    //• Name:  Triangle (constructor); input: x position of bottom left corner (double), y position
    //of bottom left corner (double), width (double), height (double)
    //• Name: calculatePerimeter; input: none; output: perimeter of the triangle (type double)
    //• Name: calculateArea; input: none; output: area of the triangle (double)
    //• Name:  setColor; input: color of the shape (type Color); output: none
    //• Name:  setPos; input: x, y position of bottom left corner (both doubles) output: none
    //• Name:  setHeight; input: height (double); output: none
    //• Name:  setWidth; input: width (double); output: none
    //• Name:  getColor; input: none; output: color of the shape (type Color)
    //• Name:  getXPos; input: none; output:  x position of the bottom left corner (double)
    //• Name:  getYPos; input: none; output:  y position of the bottom left corner (double)
    //• Name:  getHeight; input: none; output: height (double)
    //• Name:  getWidth; input: none; output: width (double)
    private double xpos;
    private double ypos;
    private double width;
    private double height;
    private Color color;

    public Triangle(double x, double y, double b, double h) {
        xpos = x;
        ypos = y;
        width = b;
        height = h;
    }

    public double calculatePerimeter() {
        return width + (2 * Math.sqrt((width / 2) + height));
    }

    public double calculateArea() {
        return (0.5 * width * height);
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setPos(double xpos, double ypos) {
        this.xpos = xpos;
        this.ypos = ypos;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public Color getColor() {
        return color;
    }

    public double getXPos() {
        return xpos;
    }

    public double getYPos() {
        return ypos;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }
}