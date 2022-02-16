// FractalDrawer class draws a fractal of a shape indicated by user input
import java.awt.Color;
import java.util.Scanner;

public class FractalDrawer {
    private double totalArea=0;  // member variable for tracking the total area

    public FractalDrawer() {}  // constructor

    // drawFractal creates a new Canvas object
    // and determines which shapes to draw a fractal by calling appropriate helper function
    // drawFractal returns the area of the fractal
    public double drawFractal(String type) {
        Canvas canvas1 = new Canvas(1200, 1800);
        if (type.equals("circle")) {
            drawCircleFractal(100, 500, 500, Color.BLUE, canvas1, 8);
            //values are meaningless and mere examples
            //I am not creative, so I won't even attempt to create a Magic-Eye-type puzzle aesthetic
            return totalArea;
        } else if (type.equals("triangle")) {
            drawTriangleFractal(200, 200, 500, 400, Color.RED, canvas1, 8);
            //values are meaningless and mere examples
            return totalArea;
        } else if (type.equals("rectangle")) {
            drawRectangleFractal(250, 500, 100, 100, Color.YELLOW, canvas1, 8);
            //values are meaningless and mere examples
            return totalArea;
        } else {
            System.out.println("invalid shape");
            return 0;
        }
    }

    // drawTriangleFractal draws a triangle fractal using recursive techniques
    public void drawTriangleFractal(double width, double height, double x, double y, Color c, Canvas can, int level) {
        Triangle mytriangle = new Triangle(x, y, width, height);
        mytriangle.setColor(c);
        if (level == 0) { //sets base case of recursion, level refers to layers of the fractal
            can.drawShape(mytriangle);
            this.totalArea = mytriangle.calculateArea();
        } else { //recursive case
            double b2 = 0.5 * (mytriangle.getWidth());
            double h2 = 0.5 * (mytriangle.getHeight()); //generates a triangle with halved dimensions
            double x1 = mytriangle.getXPos() - (0.5 * (mytriangle.getWidth())); //setting coordinates
            double x2 = mytriangle.getXPos() + (mytriangle.getWidth());
            double x3 = mytriangle.getXPos() + (0.5 * (mytriangle.getWidth()));
            double y1 = mytriangle.getYPos();
            double y2 = mytriangle.getYPos();
            double y3 = mytriangle.getYPos() - mytriangle.getHeight();
            Triangle newTriangle1 = new Triangle(b2, h2, x1, y1);
            newTriangle1.setColor(Color.RED);
            // position offsets are such that the subsequent triangles spawn at vertices (left)
            Triangle newTriangle2 = new Triangle(b2, h2, x2, y2);
            newTriangle2.setColor(Color.BLUE);
            // position offsets are such that the subsequent triangles spawn at vertices (right)
            Triangle newTriangle3 = new Triangle(b2, h2, x3, y3);
            newTriangle3.setColor(Color.GREEN);
            // position offsets are such that the subsequent triangles spawn at vertices (top)
            can.drawShape(mytriangle);
            can.drawShape(newTriangle1);
            can.drawShape(newTriangle2);
            can.drawShape(newTriangle3);
            // sums the areas to add to the total
            drawTriangleFractal(b2, h2, x1, y1, Color.RED, can, (level - 1));
            drawTriangleFractal(b2, h2, x2, y2, Color.BLUE, can, (level - 1));
            drawTriangleFractal(b2, h2, x3, y3, Color.BLACK, can, (level - 1));
            this.totalArea += (mytriangle.calculateArea() + newTriangle1.calculateArea() + newTriangle2.calculateArea() + newTriangle3.calculateArea());
        }
    }

    // TODO:
    // drawCircleFractal draws a circle fractal using recursive techniques
    public void drawCircleFractal(double radius, double x, double y, Color c, Canvas can, int level) {
        Circle mycircle = new Circle(x, y, radius);
        mycircle.setColor(c);
        if (level == 0) {
            can.drawShape(mycircle);
            this.totalArea = mycircle.calculateArea();
        } else {
            double r = 0.5 * mycircle.getRadius();
            double x1 = mycircle.getXPos() + 3*r;
            double x2 = mycircle.getXPos();
            double y1 = mycircle.getYPos();
            double y2 = mycircle.getYPos() + 2*r;

            Circle newCircle1 = new Circle(x1, y1, r);
            Circle newCircle2 = new Circle(x2, y2, r);

            newCircle1.setColor(Color.BLACK);
            can.drawShape(mycircle);
            can.drawShape(newCircle1);

            drawCircleFractal(r, x1, y1, Color.YELLOW, can, (level - 1));
            drawCircleFractal(r, x2, y2, Color.RED, can, (level - 1));

            this.totalArea += (mycircle.calculateArea() + newCircle1.calculateArea() + newCircle2.calculateArea());
        }
}


    // drawRectangleFractal draws a rectangle fractal using recursive techniques
    public void drawRectangleFractal(double width, double height, double x, double y, Color c, Canvas can, int level) {
        Rectangle myrectangle = new Rectangle(width, height, x, y);
        myrectangle.setColor(c);
        if (level == 0) { //sets base case of recursion, level refers to layers of the fractal
            can.drawShape(myrectangle);
            this.totalArea = myrectangle.calculateArea();
        } else { //recursive case
            double b2 = 0.5 * (myrectangle.getWidth());
            double h2 = 0.5 * (myrectangle.getHeight()); //generates a rectangle with halved dimensions
            double x1 = myrectangle.getXPos() - b2; // setting coordinates for the new rectangle
            double x2 = myrectangle.getXPos() - b2;
            double x3 = myrectangle.getXPos() + myrectangle.getWidth();
            double x4 = myrectangle.getXPos() + myrectangle.getWidth();
            double y1 = myrectangle.getYPos() - h2;
            double y2 = myrectangle.getYPos() + myrectangle.getHeight();
            double y3 = myrectangle.getYPos() - h2;
            double y4 = myrectangle.getYPos() + myrectangle.getHeight();

            Rectangle newRectangle1 = new Rectangle(b2, h2, x1, y1);
            Rectangle newRectangle2 = new Rectangle(b2, h2, x2, y2);
            Rectangle newRectangle3 = new Rectangle(b2, h2, x3, y3);
            Rectangle newRectangle4 = new Rectangle(b2, h2, x4, y4);
            can.drawShape(myrectangle);
            can.drawShape(newRectangle1);
            newRectangle1.setColor(Color.RED);
            can.drawShape(newRectangle2);
            newRectangle2.setColor(Color.BLUE);
            can.drawShape(newRectangle3);
            newRectangle3.setColor(Color.GREEN);
            can.drawShape(newRectangle4);
            newRectangle4.setColor(Color.YELLOW);

            drawRectangleFractal(b2, h2, x1, y1, Color.RED, can, (level - 1));
            drawRectangleFractal(b2, h2, x2, y2, Color.BLUE, can, (level - 1));
            drawRectangleFractal(b2, h2, x3, y3, Color.GREEN, can, (level - 1));
            drawRectangleFractal(b2, h2, x4, y4, Color.YELLOW, can, (level - 1));
            this.totalArea += (myrectangle.calculateArea() + newRectangle1.calculateArea() + newRectangle2.calculateArea() + newRectangle3.calculateArea()) + newRectangle4.calculateArea();
            // sums the areas to add to the total
        }
    }

    // main should ask user for shape input, and then draw the corresponding fractal.
    // should print area of fractal
    public static void main(String[] args) {
        Scanner shapeprompt = new Scanner(System.in);
        System.out.println("Enter shape:");
        String shape = shapeprompt.nextLine();
        FractalDrawer fractalDrawer = new FractalDrawer();
        double output = fractalDrawer.drawFractal(shape);
        System.out.println("Total Area: " + output);
    }
}
