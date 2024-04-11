package 메서드_기능분할;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Code04 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner inFile = new Scanner(new File("input.txt"));
        String[] name = new String[100];
        String[] number = new String[100];
        int count = 0;

        while (inFile.hasNext()) {
            name[count] = inFile.next();
            number[count] = inFile.next();
            count++;
        }
        inFile.close();

        for (int i = 0; i < count; i++)
            System.out.println("Name: " + name[i] + ", Phone: " + number[i]);
    }
}
