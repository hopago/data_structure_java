package 메서드_생성자;

public class MyTerm {
    int coef;
    int exp;

    MyTerm(int c, int e) {
        coef = c;
        exp = e;
    }

    int calcTerm(int x) {
        return (int) (coef * Math.pow(x, exp));
    }

    void printTerm() {
        System.out.println(coef + "x^" + exp);
    }
}
