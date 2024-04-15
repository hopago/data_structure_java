package 클래스_객체_참조;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Code04 {
    static WordIndex[] wordIndex = new WordIndex[1000];
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
                    System.out.println("Word " + wordIndex[findIndex].word + " Counted " + wordIndex[findIndex].count);
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
            System.out.println(wordIndex[i].word);
    }

    public static void saveAs(String fileName) {
        PrintWriter out;
        
        try {
            out = new PrintWriter(new FileWriter(fileName));

            for (int i = 0; i < n; i++) {
                out.println(wordIndex[i].word + " : " + wordIndex[i].count);
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

                String trimmedInputWord = trimming(inputWord);

                if (trimmedInputWord != null) {
                    addWord(trimmedInputWord.toLowerCase());
                }
            }

            targetFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            return;
        }
    }

    public static String trimming(String inputWord) {
        if (inputWord == null || inputWord.length() <= 0)
            return null;

        int i = 0, j = inputWord.length() - 1;

        while (i < inputWord.length() && !Character.isLetter(inputWord.charAt(i))) {
            i++;
        }
        while (j >= 0 && !Character.isLetter(inputWord.charAt(j))) {
            j--;
        }

        if (i <= j)
            return inputWord.substring(i, j + 1);
        else
            return null;
    }

    public static void addWord(String inputWord) {
        int findIndex = findIndex(inputWord);

        if (findIndex != -1) {
            wordIndex[findIndex].count++;
        } else {
            int i = n - 1;
            while (i >= 0 && wordIndex[i].word.compareTo(inputWord) > 0) {
                wordIndex[i + 1] = wordIndex[i];
                i--;
            }

            wordIndex[i + 1] = new WordIndex();
            wordIndex[i + 1].word = inputWord;
            wordIndex[i + 1].count = 1;
            n++;
        }
    }

    public static int findIndex(String inputWord) {
        for (int i = 0; i < n; i++) {
            if (wordIndex[i].word.equalsIgnoreCase(inputWord))
                return i;
        }

        return -1;
    }
}
