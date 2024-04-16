package 클래스_객체_참조;

import java.util.Scanner;

public class Code06 {
    static MyPolynomial[] polynomials = new MyPolynomial[100];
    static int n = 0;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        while (true) {
            System.out.print("$ ");
            String command = kb.next();

            if (command.equals("create")) {
                char name = kb.next().charAt(0);

                polynomials[n] = new MyPolynomial();
                polynomials[n].name = name;
                polynomials[n].n = 0;
                n++;
            } else if (command.equals("add")) {
                char name = kb.next().charAt(0);
                int findIdx = find(name);

                if (findIdx == -1) {
                    System.out.println("Polynomial not found.");
                } else {
                    int c = kb.nextInt();
                    int e = kb.nextInt();
                    addTerm(polynomials[findIdx], c, e);
                }
            } else if (command.equals("calc")) {
                char name = kb.next().charAt(0);
                int findIdx = find(name);

                if (findIdx == -1) {
                    System.out.println("Polynomial not found.");
                } else {
                    int x = kb.nextInt();
                    int result = calcPolynomial(polynomials[findIdx], x);

                    System.out.println(result);
                }
            } else if (command.equals("print")) {
                char name = kb.next().charAt(0);
                int findIdx = find(name);

                if (findIdx == -1) {
                    System.out.println("Polynomial not found.");
                } else {
                    printPolynomial(polynomials[findIdx]);
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

    public static void addTerm(MyPolynomial polynomial, int c, int e) {
        int idx = findTerm(polynomial, e);
        if (idx != -1) {
            polynomial.terms[idx].coef += c;
        } else {
            int i = polynomial.n - 1;

            while (i >= 0 && polynomial.terms[i].exp < e) {
                polynomial.terms[i + 1] = polynomial.terms[i];
                i--;
            }

            polynomial.terms[i + 1] = new MyTerm();
            polynomial.terms[i + 1].coef = c;
            polynomial.terms[i + 1].exp = e;
            polynomial.n++;
        }
    }

    public static int findTerm(MyPolynomial p, int e) {
        for (int i = 0; i < p.n && p.terms[i].exp >= e; i++) {
            if (p.terms[i].exp == e) {
                return i;
            }
        }

        return -1;
    }

    public static int calcPolynomial(MyPolynomial p, int x) {
        int result = 0;

        for (int i = 0; i < p.n; i++) {
            result += calcTerm(p.terms[i], x);
        }

        return result;
    }

    public static int calcTerm(MyTerm term, int x) {
        return (int) (term.coef * Math.pow(x, term.exp));
    }

    public static void printPolynomial(MyPolynomial polynomial) {
        for (int i = 0; i < polynomial.n; i++) {
            printTerm(polynomial.terms[i]);
            System.out.print(" + ");
        }

        System.out.println();
    }

    public static void printTerm(MyTerm term) {
        System.out.print(term.coef + "x^" + term.exp);
    }
}
