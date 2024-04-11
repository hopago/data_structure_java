package 메서드_기능분할;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Code05 {
    static String[] name = new String[1000];
    static String[] number = new String[1000];
    static int count = 0;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner inFile = new Scanner(new File("input.txt"));

        while (inFile.hasNext()) {
            name[count] = inFile.next();
            number[count] = inFile.next();
            count++;
        }
        inFile.close();

        bubbleSort();

        for (int i = 0; i < count; i++)
            System.out.println("Name: " + name[i] + ", Phone: " + number[i]);
    }

    public static void bubbleSort() {
        for (int i = count - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (name[j].compareTo(name[j + 1]) > 0) {
                    String tmp = name[j];
                    name[j] = name[j + 1];
                    name[j + 1] = tmp;

                    tmp = number[j];
                    number[j] = number[j + 1];
                    number[j + 1] = tmp;
                }
            }
        }
    }
}
