package 메서드_생성자;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Code03 {
    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(new File("data.txt"));
            int n = in.nextInt();
            OrthoPolygon newPolygon = new OrthoPolygon(n);

            for (int i = 0; i < n; i++) {
                newPolygon.addVertex(in.nextInt(), in.nextInt());
            }

            MyPoint point = new MyPoint(in.nextInt(), in.nextInt());

            in.close();

            if (newPolygon.contains(point)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        } catch (FileNotFoundException e) {

        }
    }
}
