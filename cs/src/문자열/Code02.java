package 문자열;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Code02 {
    static String[] words = new String[10000];
    static int[] count = new int[10000];
    static int n = 0;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        while (true) {
            System.out.print("$ ");
            String command = kb.next();
            if (command.equals("read")) {
                String fileName = kb.next();

                makeIndexData(fileName);
            } else if (command.equals("find")) {
                String targetWord = kb.next();
                int findIndex = findIndex(targetWord);

                if (findIndex != -1) {
                    System.out.println("Word " + words[findIndex] + " Counted " + count[findIndex]);
                } else {
                    System.out.println("Word not found.");
                }
            } else if (command.equals("saveAs")) {
                String fileName = kb.next();
                saveAs(fileName);
            } else if (command.equals("exit")) {
                break;
            } else {
                System.out.println("Unknown keyword");
                break;
            }
        }

        kb.close();

        for (int i = 0; i < n; i++)
            System.out.println(words[i] + " " + count[i]);
    }

    public static void saveAs(String fileName) {
        PrintWriter out;
        try {
            out = new PrintWriter(new FileWriter(fileName));

            for (int i = 0; i < n; i++) {
                out.println(words[i] + " " + count[i]);
            }

            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void makeIndexData(String fileName) {
        try {
            Scanner targetFile = new Scanner(new File(fileName));

            while (targetFile.hasNext()) {
                String inputWord = targetFile.next();

                addWord(inputWord);
            }

            targetFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            return;
        }
    }

    public static void addWord(String inputWord) {
        int findIndex = findIndex(inputWord);

        if (findIndex != -1) {
            count[findIndex]++;
        } else {
            words[n] = inputWord;
            count[n] = 1;
            n++;
        }
    }

    public static int findIndex(String inputWord) {
        for (int i = 0; i < n; i++) {
            if (words[i].equalsIgnoreCase(inputWord))
                return i;
        }

        return -1;
    }
}
