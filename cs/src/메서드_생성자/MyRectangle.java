package 메서드_생성자;

public class MyRectangle {
    MyPoint lu;
    int width;
    int height;

    MyRectangle(int x, int y, int w, int h) {
        lu = new MyPoint(x, y);
        width = w;
        height = h;
    }

    int calcArea() {
        return width * height;
    }

    public String toString() {
        return "x, y: " + lu.x + " " + lu.y + " / width & height: " + width + " " + height;
    }
}
