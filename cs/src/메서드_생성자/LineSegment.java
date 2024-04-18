package 메서드_생성자;

public class LineSegment {
    MyPoint u;
    MyPoint v;

    LineSegment(MyPoint p, MyPoint q) {
        u = p;
        v = q;

        if (p.x > q.x || p.x == q.x && p.y > q.y) {
            swap();
        }
    }

    LineSegment(int x1, int y1, int x2, int y2) {
        u = new MyPoint(x1, y1);
        v = new MyPoint(x2, y2);
    }

    void swap() {
        MyPoint tmp = u;
        u = v;
        v = tmp;
    }

    boolean isVertical() {
        return u.x == v.x;
    }

    boolean intersects(LineSegment anotherLine) {
        if (isVertical() && !anotherLine.isVertical()) {
            return anotherLine.u.x < u.x && anotherLine.v.x > u.x && anotherLine.u.y > u.y && anotherLine.u.y < u.y;
        } else if (!isVertical() && anotherLine.isVertical()) {
            return anotherLine.u.y < u.y && anotherLine.v.y > u.y && anotherLine.u.x > u.x && anotherLine.u.x < v.x;
        } else {
            return false;
        }
    }
}
