package test1212;

class Shape {
  String color = "gold"; // 공통속성

  void draw() {
    System.out.println("그리다"); // 공통기능
  }
}

class Point {
  int x;
  int y;

  Point() {
    this(1, 2);
  }

  Point(int x, int y) {
    this.x = x;
    this.y = y;
  }
}

class Triangle extends Shape {
  
  private Point[] points;
  
  public Triangle() {
    this(new Point[]{new Point(1,2),new Point(3,4),new Point(5,6)});
    }
  
  public Triangle(Point[] points) {
    this.points = points;
  }
  
  void draw(Point[] points) {
    System.out.print("삼각형 그리기 ");
    for(int i = 0; i < points.length; i++) {
      System.out.print("(" + points[i].x +  ", " + points[i].y + ")");
      
      if(i == points.length -1) return;
      else System.out.print(", ");
    }
  }

  public Point[] getPoints() {
    return points;
  }

  public void setPoints(Point[] points) {
    this.points = points;
  }
  
}
