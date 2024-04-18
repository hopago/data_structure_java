package 메서드_생성자;

public class Polynomial {
    char name;
    int n;
    MyTerm[] terms;

    Polynomial(char name) {
        this.name = name;
        n = 0;
        terms = new MyTerm[100];
    }

    int calcPolynomial(int x) {
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += terms[i].calcTerm(x);
        }
        return result;
    }

    void printPolynomial() {
        for (int i = 0; i < n; i++) {
            printTerm(terms[i]);
            System.out.print(" + ");
        }
        System.out.println();
    }

    void printTerm(MyTerm term) {
        System.out.print(term.coef + "x^" + term.exp);
    }

    void addTerm(int c, int e) {
        int idx = findTerm(e);
        if (idx != -1) {
            terms[idx].coef += c;
        } else {
            int i = n - 1;

            while (i >= 0 && terms[i].exp < e) {
                terms[i + 1] = terms[i];
                i--;
            }

            terms[i + 1] = new MyTerm(c, e);
            n++;
        }
    }

    int findTerm(int e) {
        for (int i = 0; i < n && terms[i].exp >= e; i++) {
            if (terms[i].exp == e) {
                return i;
            }
        }

        return -1;
    }
}
