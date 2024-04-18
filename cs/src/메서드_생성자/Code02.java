package 메서드_생성자;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Code02 {
    static MyRectangle[] rectangles = new MyRectangle[100];
    static int n = 0;

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(new File("point-data.txt"));

            while (in.hasNext()) {
                rectangles[n] = new MyRectangle(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt());
                n++;
            }

            in.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
            System.exit(1);
        }

        bubbleSort();

        for (int i = 0; i < n; i++) {
            System.out.println(rectangles[i].toString());
        }
    }

    public static void bubbleSort() {
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (rectangles[j].calcArea() > rectangles[j + 1].calcArea()) {
                    MyRectangle tmp = rectangles[j];
                    rectangles[j] = rectangles[j + 1];
                    rectangles[j + 1] = tmp;
                }
            }
        }
    }
}
