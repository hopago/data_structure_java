package 문자열;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Code01 {
    static String[] names = new String[1000];
    static String[] numbers = new String[1000];
    static int n = 0;

    public static void main(String[] args) {
        Scanner file;
        try {
            file = new Scanner(new File("input.txt"));

            while (file.hasNext()) {
                names[n] = file.next();
                numbers[n] = file.next();
                n++;
            }
            file.close();

            bubbleSort();

            for (int i = 0; i < n; i++) {
                System.out.println("Names: " + names[i] + ", Phone: " + numbers[i]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static public void bubbleSort() {
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (numbers[j].compareTo(numbers[j + 1]) > 0) {
                    String tmp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = tmp;

                    String tmpName = names[j];
                    names[j] = names[j + 1];
                    names[j + 1] = tmpName;
                }
            }
        }
    }
}
