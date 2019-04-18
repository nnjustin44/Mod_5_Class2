/* Justin Nguyen
Professor Sarah North
CS W01 Online 1302
MOD_5
 */








import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
public class  TwoRec {
    private double x;
    private double y;
    private double width;
    private double height;
    //Default constructor to initialize a rectangle at (0,0) position
    public TwoRec() {
        x = 0;
        y = 0;
        width = 1;
        height = 1;
    }
    //parameterized constructor to initialize rectangle with given coordinates and height, width
    public TwoRec(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    //method to calculate and return the area @return (area of rectangle=width x height)
    public double getArea() {
        return width * height;
    }

    //method to calculate and return the perimeter @return (perimeter of rectangle=2x (width + height))
    public double getPerimeter() {
        return 2.0 * (width + height);
    }
    //method to check if the coords x, y are inside current rectangle
    public boolean contains(double X, double Y) {

        //As x, y represents the center of the rectangle, x-width/2 will be the leftmost coordinate of the rectangle, x+width/2 will be the righmost, and similarly, for the y coords
        double xStart = x - (width / 2);
        double xEnd = x + (width / 2);
        double yStart = y - (height / 2);
        double yEnd = y + (height / 2);
        if (X >= xStart && X <= xEnd && Y >= yStart && Y <= yEnd) {
            // point is inside
            return true;
        }
        return false;
    }
    // method to check if a rectangle is inside the current rectangle
    public boolean contains(TwoRec r) {
        //calculating the bounds of this rectangle
        double x1Start = x - (width / 2);
        double x1End = x + (width / 2);
        double y1Start = y - (height / 2);
        double y1End = y + (height / 2);
        //calculating the top left, bottom right bounds of rectangle in the parameter
        double x2Start = r.getX() - (r.getWidth() / 2);
        double x2End = r.getX() + (r.getWidth() / 2);
        double y2Start = r.getY() - (r.getHeight() / 2);
        double y2End = r.getY() + (r.getHeight() / 2);
        //checking if all bounds of other rectangle are within this rectangle
        if (x2Start >= x1Start && x2End <= x1End && y2Start >= y1Start
                && y2End <= y1End) {
            return true;
        }
        return false;
    }
    //method to find if two rectangles are overlapping
    public boolean overlaps(TwoRec r) {
        // calculating the bounds of this rectangle
        double x1Start = x - (width / 2);
        double x1End = x + (width / 2);
        double y1Start = y - (height / 2);
        double y1End = y + (height / 2);
        //calculating the bounds of rectangle in the parameter
        double x2Start = r.getX() - (r.getWidth() / 2);
        double x2End = r.getX() + (r.getWidth() / 2);
        double y2Start = r.getY() - (r.getHeight() / 2);
        double y2End = r.getY() + (r.getHeight() / 2);
        if (contains(x2Start, y2Start) || contains(x2End, y2Start)
                || contains(x2Start, y2End) || contains(x2End, y2End)
                || r.contains(x1Start, y1Start) || r.contains(x1End, y1Start)
                || r.contains(x1Start, y1End) || r.contains(x1End, y1End)
                || contains(r.x, r.y) || r.contains(this.x, this.y)) {
            //If any bound of the given rectangle is inside the current rectangle or if any bound of the current rectangle is inside the given rectangle, that means the rectangles are overlapping
            return true;
        }
        return false; // not overlapping
    }
    // getters and setters
    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }
    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }
    public double getWidth() {
        return width;
    }
    public void setWidth(double width) {
        this.width = width;
    }
    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }
}
// Test.java (to create and display rectangles)
import java.awt.Color;
import java.awt.Graphics;
import java.util.Scanner;
import javax.swing.JFrame;
    public class Test extends JFrame {
        // instance variables
        TwoRec rect1, rect2;
        //constructor to initialize with two MyRectangle2D objects
        public Test(TwoRec rect1, TwoRec rect2) {
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setSize(500, 500); // setting size
            // assigning rectangles to instance variables, so that paint method can
            // draw it
            this.rect1 = rect1;
            this.rect2 = rect2;
            getContentPane().setBackground(Color.WHITE);
            setVisible(true);
        }
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            if (rect1 != null && rect2 != null) {
                //Extracting the coordinates and drawing the two rectangles
                int x, y, width, height;
                width = (int) rect1.getWidth();
                height = (int) rect1.getHeight();
                x = (int) rect1.getX() - width / 2;
                y = (int) rect1.getY() - height / 2;
                g.drawRect(x, y, width, height);
                width = (int) rect2.getWidth();
                height = (int) rect2.getHeight();
                x = (int) rect2.getX() - width / 2;
                y = (int) rect2.getY() - height / 2;
                g.drawRect(x, y, width, height);
                String text = "";
                //checking if one rectangle is within other or overlapping
                if (rect1.contains(rect2) || rect2.contains(rect1)) {
                    text = "One rectangle is contained in another";
                } else if (rect1.overlaps(rect2) || rect2.overlaps(rect1)) {
                    text = "The rectangles overlap";
                } else {
                    text = "The rectangles do not overlap";
                }
                g.drawString(text, getWidth() / 2, getHeight() - 50);
            }
        }
        public static void main(String[] args) {
            //Reading coordinates and attributes for two rectangles
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter x, y, width & height of first rectangle: ");
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            double width = scanner.nextDouble();
            double height = scanner.nextDouble();
            scanner.nextLine();
            //creating rectangle1
            TwoRec rect1 = new TwoRec(x, y, width, height);
            System.out.print("Enter x, y, width & height of second rectangle: ");
            x = scanner.nextDouble();
            y = scanner.nextDouble();
            width = scanner.nextDouble();
            height = scanner.nextDouble();
            scanner.nextLine();
            //creating rectangle2
            TwoRec rect2 = new TwoRec(x, y, width, height);
            //passing these two rectangles to the Test class constructor
            Test test = new Test(rect1, rect2);

        }

    }

