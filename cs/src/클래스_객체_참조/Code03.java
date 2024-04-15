package 클래스_객체_참조;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Code03 {
    static Person01[] members = new Person01[100];
    static int n = 0;

    public static void main(String[] args) {
        Scanner personInputs;

        try {
            personInputs = new Scanner(new File("input.txt"));

            while (personInputs.hasNext()) {
                String name = personInputs.next();
                String number = personInputs.next();

                members[n] = new Person01();
                members[n].name = name;
                members[n].number = number;
                n++;
            }

            personInputs.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
            System.exit(1);
        }

        for (int i = 0; i < n; i++) {
            System.out.println(members[i].name);
        }
    }
}
