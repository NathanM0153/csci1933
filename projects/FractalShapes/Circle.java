import java.awt.*;

public class Circle {
    //• Name: Circle (constructor);  input: x position (double), y position (double),
    //radius (double)
    //• Name: calculatePerimeter; input: none; output: perimeter of the circle (type double)
    //• Name: calculateArea; input: none; output: area of the circle (double)
    //• Name:  setColor; input: color of the shape (type Color); output: none
    //• Name:  setPos; input: x, y position of the center (both doubles) output: none
    //• Name:  setRadius; input: radius (double) output: none
    //• Name:  getColor; input: none; output: color of the shape (type Color)
    //• Name:  getXPos; input: none; output:  x position of the center (double)
    //• Name:  getYPos; input: none; output:  y position of the center (double)
    //• Name:  getRadius; input: none; output: radius (double)
    private double xpos;
    private double ypos;
    private double rad;
    private Color color;
    public Circle(double x, double y, double r) {
        xpos = x;
        ypos = y;
        rad = r;
    }
    public double calculatePerimeter() {
        return 2 * Math.PI * rad;
    }
    public double calculateArea() {
        return (Math.PI) * rad * rad;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    public void setPos(double xpos, double ypos) {
        this.xpos = xpos;
        this.ypos = ypos;
    }
    public void setRadius(double rad) {
        this.rad = rad;
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
    public double getRadius() {
        return rad;
    }
}
