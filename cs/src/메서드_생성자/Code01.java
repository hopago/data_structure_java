package 메서드_생성자;

import java.util.Scanner;

public class Code01 {
    static Polynomial[] polynomials = new Polynomial[100];
    static int n = 0;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        while (true) {
            System.out.print("$ ");
            String command = kb.next();

            if (command.equals("create")) {
                char name = kb.next().charAt(0);

                polynomials[n] = new Polynomial(name);
                n++;
            } else if (command.equals("add")) {
                char name = kb.next().charAt(0);
                int findIdx = find(name);

                if (findIdx == -1) {
                    System.out.println("Polynomial not found.");
                } else {
                    int c = kb.nextInt();
                    int e = kb.nextInt();

                    polynomials[findIdx].addTerm(c, e);
                }
            } else if (command.equals("calc")) {
                char name = kb.next().charAt(0);
                int findIdx = find(name);

                if (findIdx == -1) {
                    System.out.println("Polynomial not found.");
                } else {
                    int x = kb.nextInt();
                    int result = polynomials[findIdx].calcPolynomial(x);

                    System.out.println(result);
                }
            } else if (command.equals("print")) {
                char name = kb.next().charAt(0);
                int findIdx = find(name);

                if (findIdx == -1) {
                    System.out.println("Polynomial not found.");
                } else {
                    polynomials[findIdx].printPolynomial();
                }
            } else if (command.equals("exit"))
                break;
        }

        kb.close();
    }

    public static int find(char name) {
        for (int i = 0; i < n; i++) {
            if (polynomials[i].name == name) {
                return i;
            }
        }

        return -1;
    }
}
