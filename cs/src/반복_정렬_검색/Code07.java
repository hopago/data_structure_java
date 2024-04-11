package 반복_정렬_검색;
import java.util.Scanner;

public class Code07 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] data = new int[n];

        for (int i = 0; i < n; i++) {
            data[i] = kb.nextInt();
        }
        
        kb.close();

        int sum = 0, max = data[0];

        for (int i = 0; i < n; i++) {
            sum += data[i];

            if (data[i] > max)
                max = data[i];
        }

        System.out.println("Sum " + sum + "Max " + max);
    }
}
