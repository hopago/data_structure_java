package 메서드_기능분할;

import java.util.Scanner;

public class Code01 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter two integers and press Enter.");

        int a = keyboard.nextInt();
        int b = keyboard.nextInt();

        int result = power(a, b);
        System.out.println(result);
        keyboard.close();
    }

    public static int power(int n, int m) {
        int result = 1;
        for (int i = 0; i < m; i++) {
            result *= n;
        }
        return result;
    }
}
