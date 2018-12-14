package test1212;

public class ShapeTest {
   public static void main(String[] args) {
    Point[] points = new Point[3];
    points[0] = new Point();
    points[1] = new Point(2,5);
    points[2] = new Point(3,6);
    
    Triangle triangle = new Triangle(points);
    System.out.println(triangle.color);
    triangle.draw();
    triangle.draw(points);
    
  }
}
