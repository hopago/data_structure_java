import java.util.Scanner;

class Code02 {

    public static void main(String[] args) {
        int number = 123;

        Scanner keyboard = new Scanner(System.in);

        int input = keyboard.nextInt();

        if (input == number) {
            System.out.println("Numbers match!");
        } else {
            System.out.println("Numbers do not match!");
        }

        keyboard.close();
    }
}