package 메서드_생성자;

public class OrthoPolygon {
    int n;
    MyPoint[] points;

    OrthoPolygon(int k) {
        n = 0;
        points = new MyPoint[k];
    }

    void addVertex(int x, int y) {
        points[n++] = new MyPoint(x, y);
    }

    int maxX() {
        int max = points[0].x;
        for (int i = 0; i < n; i++) {
            if (points[i].x > max) {
                max = points[i].x;
            }
        }

        return max;
    }

    boolean contains(MyPoint p) {
        LineSegment arrow = new LineSegment(p, new MyPoint(maxX() + 1, p.y));

        int count = 0;

        for (int i = 0; i < n; i++) {
            LineSegment edge = new LineSegment(points[i], points[(i + 1) % n]);

            if (arrow.intersects(edge)) {
                count++;
            }
        }

        return count % 2 == 1;
    }
}
