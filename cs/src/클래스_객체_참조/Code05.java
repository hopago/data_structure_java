package 클래스_객체_참조;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Code05 {
    static MyRectangle01[] rectangles = new MyRectangle01[100];
    static int n = 0;

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(new File("point-data.txt"));

            while (in.hasNext()) {
                rectangles[n] = new MyRectangle01();
                rectangles[n].leftUpper = new MyPoint01();

                rectangles[n].leftUpper.x = in.nextInt();
                rectangles[n].leftUpper.y = in.nextInt();
                rectangles[n].width = in.nextInt();
                rectangles[n].height = in.nextInt();
                n++;
            }

            in.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
            System.exit(1);
        }

        bubbleSort();

        for (int i = 0; i < n; i++) {
            System.out.println(rectangles[i].width + " , " + rectangles[i].height);
        }
    }

    public static void bubbleSort() {
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (calcArea(rectangles[j]) > calcArea(rectangles[j + 1])) {
                    MyRectangle01 tmp = rectangles[j];
                    rectangles[j] = rectangles[j + 1];
                    rectangles[j + 1] = tmp;
                }
            }
        }
    }

    public static int calcArea(MyRectangle01 rectangle) {
        return rectangle.width * rectangle.height;
    }
}
