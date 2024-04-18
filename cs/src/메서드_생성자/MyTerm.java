package 메서드_생성자;

public class MyTerm {
    int coef;
    int exp;

    int calcTerm(int x) {
        return (int) (coef * Math.pow(x, exp));
    }

    void printTerm() {
        System.out.println(coef + "x^" + exp);
    }
}
